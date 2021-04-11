package ro.poc.kinesis.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.poc.kinesis.api.entity.model.Sample;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("time")
public class TimeBucket {
    @Id
    private String id;

    private String type;
    private Integer bucketSize;
    private Long first;
    private Long last;
    private List<Sample> samples;
}
