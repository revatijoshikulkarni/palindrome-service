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
import java.util.List;

@Component
@AllArgsConstructor
public class PalindromeHelper {
    private final PalindromeData palindromeData;
    private final PalindromeDataRepository repository;
    private final PalindromeAttribute palindromeAttribute;

    public void readPalindromeData(){
        Iterable<PalindromeData> data = repository.findAll();
        //Palindrome palindrome
        data.forEach(palindromeData1 -> {
            Palindrome palindrome = palindromeData1.getPayLoad();
            addPalindromeLength(palindrome);
        });
    }

    private void addPalindromeLength(Palindrome palindrome){

    }

    private PalindromeAttribute calculateLongestPalindromeString(String palindromeString){
        int maxLength = 1;

        int start = 0;
        int len = palindromeString.length();

        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i)
        {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && palindromeString.charAt(low) == palindromeString.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && palindromeString.charAt(low) == palindromeString.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        palindromeAttribute.builder()
                .palindromeLongestLength(maxLength)
                .palindromeLongestSubString(palindromeString.substring(start,start+maxLength-1));
        return palindromeAttribute;

    }
}
