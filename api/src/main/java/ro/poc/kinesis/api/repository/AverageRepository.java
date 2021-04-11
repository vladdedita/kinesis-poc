package ro.poc.kinesis.api.repository;

import org.springframework.data.repository.CrudRepository;
import ro.poc.kinesis.api.entity.AverageBucket;

public interface AverageRepository extends CrudRepository<AverageBucket,String> {
}
