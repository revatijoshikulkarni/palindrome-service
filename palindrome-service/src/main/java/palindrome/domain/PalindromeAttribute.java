package palindrome.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
@AllArgsConstructor
public class PalindromeAttribute {

    private int palindromeLongestLength;
    private String palindromeLongestSubString;

}
