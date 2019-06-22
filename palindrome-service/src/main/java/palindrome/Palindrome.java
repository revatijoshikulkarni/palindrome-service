package palindrome;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Palindrome {

    @Setter
    @Getter
    @NotNull(message="content is mandatory")
    private String content;

    @Setter
    @Getter
    @NotNull(message="timestamp is mandatory")
    private String timestamp;

}
