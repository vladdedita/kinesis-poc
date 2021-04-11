package ro.poc.kinesis.consumer.service;

import ro.poc.kinesis.consumer.dto.SampleDTO;

public interface MongoService {
    void updateTimeBucket(SampleDTO sampleDTO);
    void updateAverageBucket(SampleDTO sampleDTO);
}
