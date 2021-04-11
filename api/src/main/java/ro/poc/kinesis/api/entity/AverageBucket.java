package ro.poc.kinesis.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("average")
public class AverageBucket {
    @Id
    private String id;

    private String type;
    private Long processedCount;
    private Double totalValue;
}
