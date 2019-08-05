package palindrome.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import palindrome.domain.Palindrome;
import palindrome.domain.PalindromeAttribute;
import palindrome.repository.PalindromeData;
import palindrome.repository.PalindromeDataRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
@AllArgsConstructor
public class PalindromeHelper {
    private final PalindromeData palindromeData;
    private final PalindromeDataRepository repository;
    private final PalindromeAttribute palindromeAttribute;

    public List<Palindrome> getUpdatedPalindromeData(){
        Iterable<PalindromeData> data = repository.findAll();
        List<Palindrome> updatedPalindromeList = new ArrayList<>();
        //Palindrome palindrome
        data.forEach(palindromeData1 -> {
            Palindrome palindrome = palindromeData1.getPayLoad();
            int longestPalindromeLength = longestPalindromesIn(palindrome.getContent());
            palindrome.setLength(longestPalindromeLength);
            updatedPalindromeList.add(palindrome);
        });
        return updatedPalindromeList;
    }

    private int longestPalindromesIn(String input) {
        // longest palindromes found until now
        List<String> result = new ArrayList<>();
        // length of longest palindrome found until now (all strings in result have this length)
        // initialize to a negative value to make sure that the first palindrome found will appear to be longer
        int longest = -1;
        // iterate over all possible substrings
        for (int start = 0; start <= input.length(); start++) {
            for (int end = start; end <= input.length(); end++) {
                String currentSubstring = input.substring(start, end);
                // only consider if at least as long as the longest palindrome already found
                if (currentSubstring.length() >= longest) {
                    if (isPalindrome(currentSubstring)) {
                        if (currentSubstring.length() > longest) {
                            // discard palindromes shorter than the one we have just found
                            result.clear();
                            longest = currentSubstring.length();
                        }
                        result.add(currentSubstring);
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
