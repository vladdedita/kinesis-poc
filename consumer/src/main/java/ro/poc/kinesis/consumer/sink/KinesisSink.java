package ro.poc.kinesis.consumer.sink;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
@EnableScheduling
public class KinesisSink {

    @StreamListener("input")
    public void consume(String payload) {
        System.out.println("Received: " + payload);
    }

}
