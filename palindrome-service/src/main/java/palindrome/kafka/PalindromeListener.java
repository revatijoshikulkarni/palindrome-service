package palindrome.kafka;

import lombok.AllArgsConstructor;
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
import palindrome.repository.PalindromeData;
import palindrome.repository.PalindromeDataRepository;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

@Component
@Slf4j
@AllArgsConstructor
@EnableBinding(Sink.class)
public class PalindromeListener {
    private final PalindromeDataRepository repository;
    private final PalindromeData palindromeData;

    @StreamListener(Sink.INPUT)
    public void receive(@Payload Palindrome palindromeMessage) {

        log.info("Received Palindrome : {}", palindromeMessage);
        log.info(" Saving payload in the database");
        palindromeData.setPayLoad(palindromeMessage.toString());
        palindromeData.setCreatedTimestamp(OffsetDateTime.now().toString());
        repository.save(palindromeData);
        log.info("Payload saved");
    }
}
