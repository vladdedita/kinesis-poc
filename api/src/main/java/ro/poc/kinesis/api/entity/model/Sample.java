package ro.poc.kinesis.api.entity.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sample {
    private String type;
    private Double value;
    private Long timestamp;
}
