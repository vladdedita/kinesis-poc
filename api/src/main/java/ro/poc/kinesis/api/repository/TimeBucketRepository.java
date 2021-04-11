package ro.poc.kinesis.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.poc.kinesis.api.entity.TimeBucket;

import java.util.List;

public interface TimeBucketRepository extends CrudRepository<TimeBucket, String> {
//    @Query
//    List<TimeBucket> findAllBetween(Long from, Long to)
}
