/*
package palindrome.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import palindrome.Palindrome;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrapAddress:localhost:9092}")
    private String bootstrapAddress;

    @Value(value = "${kafka.group_Id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, Palindrome> palindromeConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(Palindrome.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Palindrome>
    palindromeConcurrentKafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, Palindrome> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(palindromeConsumerFactory());
        return factory;
    }
}
*/
