/*
package palindrome.kafka;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.beans.factory.annotation.Value;
import palindrome.domain.Palindrome;

@ComponentScan
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@AllArgsConstructor
public class Producer {

    @Value(value = "${message.topic.name}")
    private String topicName;

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";


    private final KafkaTemplate<String, Palindrome> kafkaTemplate;
    private final KafkaProducerConfig producerConfig;

    public void sendPalindromeMessage(Palindrome message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        //this.kafkaTemplate.send(TOPIC, message);
        ListenableFuture<SendResult<String, Palindrome>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Palindrome>>() {

            @Override
            public void onSuccess(SendResult<String, Palindrome> result) {
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
*/
