package ro.poc.kinesis.consumer.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ro.poc.kinesis.consumer.sink.KinesisSource;
import ro.poc.kinesis.consumer.util.FileUtils;

import java.util.stream.Stream;


@Component
public class AppStartupRunner implements ApplicationRunner {

    @Value("${kinesis.source.filePath}")
    private String filePath;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppStartupRunner.class);

    private final KinesisSource kinesisSource;

    public AppStartupRunner(KinesisSource kinesisSource) {
        this.kinesisSource = kinesisSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info(String.format("Reading file %s and publishing messages to Kinesis Stream...", filePath));
        try (Stream<String> lines = FileUtils
                .readFileLines(filePath)) {
            lines
                    .forEach(kinesisSource::produce);
        }
    }
}
