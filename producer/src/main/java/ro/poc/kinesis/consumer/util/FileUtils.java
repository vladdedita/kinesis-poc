package ro.poc.kinesis.consumer.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.stream.Stream;

public class FileUtils {

    public static Stream<String> readFileLines(String fileName) {
        return getFileInputStream(fileName)
                .map(InputStreamReader::new)
                .map(BufferedReader::new)
                .map(BufferedReader::lines)
                .orElseThrow(() -> new IllegalArgumentException(String.format("File %s not found", fileName)));
    }

    private static Optional<InputStream> getFileInputStream(String file) {
        return Optional.ofNullable(FileUtils.class.getClassLoader().getResourceAsStream(file));
    }
}
