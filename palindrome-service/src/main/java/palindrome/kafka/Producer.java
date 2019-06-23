package palindrome.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaProducerConfig producerConfig;
    private final KafkaTopicConfig topicConfig;

    public void sendPalindromeMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        //this.kafkaTemplate.send(TOPIC, message);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicConfig.topic1().name(), message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
