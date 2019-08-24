package palindrome.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import palindrome.domain.Palindrome;
import palindrome.repository.PalindromeData;
import palindrome.repository.PalindromeDataRepository;

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
       try {
           palindromeData.setPayLoad(new ObjectMapper()
                   .writeValueAsString(palindromeMessage));
           palindromeData.setCreatedTimestamp(OffsetDateTime.now().toString());
           repository.save(palindromeData);
           log.info("Payload saved");
       }catch(Exception e){
           log.error(" Error in the listener",e.getMessage());
       }
    }
}
