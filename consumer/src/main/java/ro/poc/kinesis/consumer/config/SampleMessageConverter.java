//package ro.poc.kinesis.consumer.config;
//
//import com.mongodb.lang.Nullable;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.converter.AbstractMessageConverter;
//import org.springframework.util.MimeType;
//import ro.poc.kinesis.consumer.dto.SampleDTO;
//
//public class SampleMessageConverter extends AbstractMessageConverter {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(SampleMessageConverter.class);
//
//    public SampleMessageConverter() {
//        super(MimeType.valueOf("text/plain"));
//    }
//
//    @Override
//    protected boolean supports(Class<?> clazz) {
//        return clazz.equals(SampleDTO.class);
//    }
//
//
//
//    @Override
//    protected Object convertFromInternal(Message<?> message, Class<?> targetClass, @Nullable Object conversionHint) {
//        String payload = (String) message.getPayload();
//        String[] split = payload.split(",");
//        if (split.length != 3)
//            throw new IllegalArgumentException(String.format("Invalid message format %s", payload));
//
//        try {
//            Long timestamp = Long.valueOf(split[0]); //should be timestamp
//            String type = split[1]; //should be type
//            Double value = Double.valueOf(split[2]); //should be value
//            return SampleDTO.builder()
//                    .timestamp(timestamp)
//                    .type(type)
//                    .value(value)
//                    .build();
//        } catch (IllegalArgumentException e) {
//            LOGGER.error(String.format("Payload %s parse values failed", payload), e);
//            throw new IllegalArgumentException(String.format("Invalid message format %s", payload));
//        }
//    }
//
//}
