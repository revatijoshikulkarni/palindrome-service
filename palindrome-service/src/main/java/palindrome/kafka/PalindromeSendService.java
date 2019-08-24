package palindrome.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import palindrome.domain.Palindrome;

@Slf4j
@Service
@AllArgsConstructor
@EnableBinding(Source.class)
public class PalindromeSendService {
    private final Source source;

    public void send(final Palindrome palindromeMessage) {

        final Message<Palindrome> message = MessageBuilder.withPayload(palindromeMessage).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build();
        source.output().send(message);
    }
}
