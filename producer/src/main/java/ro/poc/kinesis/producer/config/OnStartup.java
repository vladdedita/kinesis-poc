//package ro.poc.kinesis.producer.config;
//
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.ContextStartedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import ro.poc.kinesis.producer.source.KinesisSource;
//
//@Component
//public class OnStartup {
//
//    private final KinesisSource kinesisSource;
//
//    public OnStartup(KinesisSource kinesisSource) {
//        this.kinesisSource = kinesisSource;
//    }
//
//    @EventListener
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        kinesisSource.produce("Test message");
//    }
//}
