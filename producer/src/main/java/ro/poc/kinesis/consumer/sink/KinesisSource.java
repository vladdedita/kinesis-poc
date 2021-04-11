package ro.poc.kinesis.consumer.sink;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
@EnableScheduling
public class KinesisSource {

    private final Source source;

    public KinesisSource(Source source) {
        this.source = source;
    }

    public void produce(String payload) {
        source.output().send(MessageBuilder.withPayload(payload).build());
        System.out.println("Sent " + payload);
    }

    @Scheduled(fixedRate = 2000L)
    public void sendTestMessage() {
        produce("Test message");
    }
}
