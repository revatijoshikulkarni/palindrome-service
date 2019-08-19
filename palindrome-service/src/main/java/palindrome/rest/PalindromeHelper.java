package palindrome.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import palindrome.domain.Palindrome;
import palindrome.repository.PalindromeData;
import palindrome.repository.PalindromeDataRepository;

import java.util.*;

@Slf4j
@Component
@AllArgsConstructor
public class PalindromeHelper {
    private final PalindromeData palindromeData;
    private final PalindromeDataRepository repository;

    public List<Palindrome> getUpdatedPalindromeData(){
        Iterable<PalindromeData> data = repository.findAll();
        List<Palindrome> updatedPalindromeList = new ArrayList<>();
        //Palindrome palindrome
        data.forEach(palindromeData1 -> {
            //JSONObject object = palindromeData1.getPayLoad();
            try {
               Palindrome palindrome = new ObjectMapper()
                       .readValue(palindromeData1.getPayLoad(),Palindrome.class);
                        //.readerFor(Palindrome.class)
                        //.readValue(palindromeData1.getPayLoad());
                int longestPalindromeLength = longestPalindromesIn(palindrome.getContent());
                palindrome.setLength(longestPalindromeLength);
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
        // the following is the easy way of reversing a string;
        // you may use your own code instead if you prefer
        StringBuilder reverse = new StringBuilder(candidate);
        reverse.reverse();
        return candidate.equals(reverse.toString());
    }

}
