package palindrome.domain;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Component
@ToString
@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Palindrome implements Serializable {

    @NotNull(message="content is mandatory")
    private String content;

    @NotNull(message="timestamp is mandatory")
    private String timestamp;

    private int length;

}
