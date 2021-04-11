package ro.poc.kinesis.consumer.service;


import lombok.RequiredArgsConstructor;
import org.joda.time.LocalDateTime;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ro.poc.kinesis.consumer.dto.SampleDTO;

@Service
@RequiredArgsConstructor
public class MongoServiceImpl implements MongoService {
    private final MongoTemplate mongoTemplate;

    public void updateTimeBucket(SampleDTO sample) {
        Criteria criteria = Criteria
                .where("type").is(sample.getType())
                .and("bucketSize").lt(100);

        Update update = new Update()
                .push("samples", sample)
                .inc("bucketSize", 1)
                .min("first", sample.getTimestamp())
                .max("last", sample.getTimestamp());

        Query query = Query.query(criteria);

        mongoTemplate.upsert(query, update, "time");
    }

    public void updateAverageBucket(SampleDTO sample) {

        Criteria criteria = Criteria
                .where("type").is(sample.getType());

        Update update = new Update()
                .inc("totalValue", sample.getValue())
                .inc("processedCount", 1);

        Query query = Query.query(criteria);

        mongoTemplate.upsert(query, update, "average");
    };

}
