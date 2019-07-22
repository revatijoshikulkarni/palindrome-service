package palindrome.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import palindrome.Palindrome;

@Slf4j
@Service
@AllArgsConstructor
@EnableBinding(Source.class)
public class PalindromeSendService {
    private final Source source;

    public void send(final Palindrome palindromeMessage) {

      //  MessageChannel messageChannel = palindromeStream.outboundMessage();

        final Message<Palindrome> message = MessageBuilder.withPayload(palindromeMessage).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build();
        source.output().send(message);
       //messageChannel.send(MessageBuilder
       //         .withPayload(palindromeMessage)
       //         .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
        //        .build());
    }
}
