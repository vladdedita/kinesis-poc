package ro.poc.kinesis.consumer.sink;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import ro.poc.kinesis.consumer.dto.SampleDTO;
import ro.poc.kinesis.consumer.service.MongoService;

@Component
@RequiredArgsConstructor
@EnableBinding(Sink.class)
public class KinesisSink {

    private final MongoService mongoService;

    @StreamListener("input")
    public void consume(String payload) {
        //TODO Find a way to solve SampleMessageConverter
        SampleDTO sample = SampleDTO.parse(payload);
        System.out.println("Received: " + sample.toString());
        mongoService.updateTimeBucket(sample);
        mongoService.updateAverageBucket(sample);
    }

}
