package palindrome;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ComponentScan
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Application {

   // private Producer kafkaMessageProducer;
    //private Consumer kafkaMessageConsumer;

    @Setter
    @Getter
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        //ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
       // kafkaMessageProducer.sendPalindromeMessage(new Palindrome());
        //kafkaMessageConsumer.latch.await(10, TimeUnit.SECONDS);
        //setContext(context);
        //context.close();
    }

 /*   public void sendKafkaMessage(Palindrome palindromeMessage){
        try {
            kafkaMessageProducer.sendPalindromeMessage(palindromeMessage);
            kafkaMessageConsumer.latch.await(10, TimeUnit.SECONDS);
            context.close();
        }catch(InterruptedException exception){
            exception.getStackTrace();
        }
    }*/

 /*   @Bean
    public Producer messageProducer() {
        return new Producer();
    }

    @Bean
    public Consumer messageListener() {
        return new Consumer();
    }
*/
}
