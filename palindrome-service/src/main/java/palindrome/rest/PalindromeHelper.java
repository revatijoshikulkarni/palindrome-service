package palindrome.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import palindrome.domain.Palindrome;
import palindrome.repository.PalindromeData;
import palindrome.repository.PalindromeDataRepository;

import java.util.List;
import java.util.ArrayList;

@Slf4j
@Component
@AllArgsConstructor
public class PalindromeHelper {
    private final PalindromeData palindromeData;
    private final PalindromeDataRepository repository;

    public List<Palindrome> getUpdatedPalindromeData(){
        Iterable<PalindromeData> data = repository.findAll();
        List<Palindrome> updatedPalindromeList = new ArrayList<>();
        data.forEach(palindromeData1 -> {
            try {
               Palindrome palindrome = new ObjectMapper()
                       .readValue(palindromeData1.getPayLoad(),Palindrome.class);
                int longestPalindromeLength = longestPalindromesIn(palindrome.getContent());
                palindrome.setLongest_palindrome_size(longestPalindromeLength);
                updatedPalindromeList.add(palindrome);

            }catch(Exception e){
                log.error(" Unable to get palindrome data", e.getMessage());
            }

        });
        return updatedPalindromeList;
    }

    private int longestPalindromesIn(String input) {
        int longest = -1;
        for (int start = 0; start <= input.length(); start++) {
            for (int end = start; end <= input.length(); end++) {
                String currentSubstring = input.substring(start, end);
                if (currentSubstring.length() >= longest) {
                    if (isPalindrome(currentSubstring)) {
                        if (currentSubstring.length() > longest) {
                            longest = currentSubstring.length();
                        }
                    }
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String candidate) {
        StringBuilder reverse = new StringBuilder(candidate);
        reverse.reverse();
        return candidate.equals(reverse.toString());
    }

}
