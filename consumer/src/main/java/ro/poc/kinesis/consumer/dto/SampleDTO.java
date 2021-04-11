package ro.poc.kinesis.consumer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
public class SampleDTO {
    private String type;
    private Double value;
    private Long timestamp;

    public static SampleDTO parse(String payload) {
        String[] split = payload.split(",");
        if (split.length != 3)
            throw new IllegalArgumentException(String.format("Invalid message format %s", payload));

        try {
            Long timestamp = Long.valueOf(split[0]); //should be timestamp
            String type = split[1]; //should be type
            Double value = Double.valueOf(split[2]); //should be value
            return SampleDTO.builder()
                    .timestamp(timestamp)
                    .type(type)
                    .value(value)
                    .build();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Invalid message format %s", payload));
        }
    }
}
