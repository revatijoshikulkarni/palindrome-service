/*
package palindrome.kafka;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import palindrome.Palindrome;

import java.util.concurrent.CountDownLatch;

@ComponentScan
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@AllArgsConstructor
public class Consumer {

    public CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${message.topic.name}", containerFactory = "palindromeKafkaListenerContainerFactory")
    public void palindromeListener(Palindrome message) {
        System.out.println("Received message: " + message);
        this.latch.countDown();
    }
}
*/
