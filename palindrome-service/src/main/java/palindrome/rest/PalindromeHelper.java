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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
