package ro.poc.kinesis.api.mapper;

import ro.poc.kinesis.api.dto.AverageTypeValueDTO;
import ro.poc.kinesis.api.entity.AverageBucket;

public class SampleMapper {

    public static AverageTypeValueDTO toDto(AverageBucket average) {
        return AverageTypeValueDTO.builder()
                .type(average.getType())
                .processedCount(average.getProcessedCount())
                .value(average.getTotalValue() / average.getProcessedCount())
                .build();
    }

}
