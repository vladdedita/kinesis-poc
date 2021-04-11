package ro.poc.kinesis.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AverageTypeValueDTO {
    private String type;
    private Double value;
    private Long processedCount;
}
