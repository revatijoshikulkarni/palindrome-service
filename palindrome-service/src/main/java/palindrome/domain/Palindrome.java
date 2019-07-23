package palindrome.domain;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@ToString
@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Palindrome {

    @NotNull(message="content is mandatory")
    private String content;

    @NotNull(message="timestamp is mandatory")
    private String timestamp;

}
