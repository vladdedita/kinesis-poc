package ro.poc.kinesis.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ro.poc.kinesis.api.dto.AverageTypeValueDTO;
import ro.poc.kinesis.api.entity.TimeBucket;
import ro.poc.kinesis.api.entity.model.Sample;
import ro.poc.kinesis.api.mapper.SampleMapper;
import ro.poc.kinesis.api.repository.AverageBucketRepository;

import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {

    private final AverageBucketRepository averageRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public List<AverageTypeValueDTO> getAverage() {
        return StreamSupport.stream(averageRepository.findAll().spliterator(), false)
                .map(SampleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AverageTypeValueDTO getTypeAverage(String type, Long from, Long to) {

        Criteria criteria = Criteria
                .where("type").is(type);

        criteria = criteria.and("first").gte(from).and("last").lte(to)
                //interval could overlap multiple buckets
                //need to filter internal timestamps too
                .and("samples.timestamp").gte(from).lt(to);

        Query query = Query.query(criteria);
        List<Sample> samples = mongoTemplate.find(query, TimeBucket.class)
                .stream()
                .map(TimeBucket::getSamples).flatMap(Collection::stream)
                .collect(Collectors.toList());
        OptionalDouble average = samples.stream().mapToDouble(Sample::getValue).average();

        return new AverageTypeValueDTO(type, average.orElse(0), (long) samples.size());

    }

}
