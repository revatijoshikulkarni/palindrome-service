package palindrome.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import palindrome.Palindrome;

@Component
@Slf4j
@EnableBinding(Sink.class)
public class PalindromeListener {
    @StreamListener(Sink.INPUT)
    public void handleGreetings(@Payload Palindrome palindromeMessage) {
        log.info("Received Palindrome : {}", palindromeMessage);
    }
}
