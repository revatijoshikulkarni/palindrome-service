package palindrome;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Application {


    @Setter
    @Getter
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
