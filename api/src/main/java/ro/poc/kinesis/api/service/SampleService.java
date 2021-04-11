package ro.poc.kinesis.api.service;

import ro.poc.kinesis.api.dto.AverageTypeValueDTO;

import java.util.List;

public interface SampleService {
    List<AverageTypeValueDTO> getAverage();

    AverageTypeValueDTO getTypeAverage(String type, Long from, Long to);
}
