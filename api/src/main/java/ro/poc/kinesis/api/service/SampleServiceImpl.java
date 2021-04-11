package ro.poc.kinesis.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import ro.poc.kinesis.api.dto.AverageTypeValueDTO;
import ro.poc.kinesis.api.entity.AverageBucket;
import ro.poc.kinesis.api.repository.AverageRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl {

    private final AverageRepository averageRepository;

    public List<AverageTypeValueDTO> getTypeAverage() {
        return StreamSupport.stream(averageRepository.findAll().spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }


    public AverageTypeValueDTO toDto(AverageBucket average) {
        return AverageTypeValueDTO.builder()
                .type(average.getType())
                .processedCount(average.getProcessedCount())
                .value(average.getTotalValue() / average.getProcessedCount())
                .build();
    }

}
