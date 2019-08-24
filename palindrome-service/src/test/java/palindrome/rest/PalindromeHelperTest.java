package palindrome.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import palindrome.domain.Palindrome;
import palindrome.repository.PalindromeData;
import palindrome.repository.PalindromeDataRepository;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class PalindromeHelperTest {

    @MockBean
    private PalindromeDataRepository repository;

    @MockBean
    private PalindromeHelper palindromeHelper;

    @MockBean
    private PalindromeData palindromeData;

    @Before
    public void setUp(){
        palindromeHelper = new PalindromeHelper(palindromeData, repository);
    }

    @Test
    public void getUpdatedPalindromeDataTest() throws Exception {

        String content = "abracadabra";
        String timestamp = OffsetDateTime.now().toString();
        int length = 3;
        final Palindrome expectedPalindrome = Palindrome.builder()
                .content(content)
                .timestamp(timestamp)
                .longest_palindrome_size(length)
                .build();

        PalindromeData data = PalindromeData.builder()
                .payLoad(new ObjectMapper()
                        .writeValueAsString(expectedPalindrome))
                .id(1)
                .createdTimestamp(timestamp)
                .build();

        Iterable<PalindromeData> mockRepositoryData = Collections.singletonList(data);

        when(repository.findAll()).thenReturn(mockRepositoryData);
        List<Palindrome> actualResult = palindromeHelper.getUpdatedPalindromeData();
        assertThat(actualResult.get(0), is(expectedPalindrome));
        assertThat(actualResult.get(0).getLongest_palindrome_size(),
                is(expectedPalindrome.getLongest_palindrome_size()));


    }
}
