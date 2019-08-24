package palindrome;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import palindrome.domain.Palindrome;
import palindrome.repository.PalindromeData;
import palindrome.repository.PalindromeDataRepository;

import java.nio.charset.Charset;
import java.time.OffsetDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PalindromeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PalindromeDataRepository repository;

    @Test
    public void whenPostRequestValidContent_thenCorrectResponse() throws Exception {
        MediaType applicationJsonUtf8 = new MediaType(MediaType.APPLICATION_JSON_UTF8, Charset.forName("UTF-8"));
        String message = "{\"content\": \"abrakadabra\", \"timestamp\" : \"2018-10-09 00:12:12+0100\"}";
        String content = "abrakadabra";
        String timestamp = "2018-10-09 00:12:12+0100";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/palindrome")
                .content(message)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void whenPostRequestInValidContent_thenCorrectResponse() throws Exception {
        String message = "{\"timestamp\" : \"2018-10-09 00:12:12+0100\"}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/palindrome")
                .content(message)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.content", Is.is("content is mandatory")))
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void serviceShouldReturnAnEnrichedpalindrome() throws Exception {

        String content = "abracadabra";
        String timestamp = OffsetDateTime.now().toString();
        final Palindrome expectedPalindrome = Palindrome.builder()
                .content(content)
                .timestamp(timestamp)
                .build();

        PalindromeData data = PalindromeData.builder()
                .payLoad(new ObjectMapper()
                        .writeValueAsString(expectedPalindrome))
                .id(1)
                .createdTimestamp(timestamp)
                .build();

        Iterable<PalindromeData> mockRepositoryData = Collections.singletonList(data);

        when(repository.findAll()).thenReturn(mockRepositoryData);

        mockMvc.perform(get("/getenrichedpalindrome"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].content", is(expectedPalindrome.getContent())))
                .andExpect(jsonPath("$[0].timestamp", is(expectedPalindrome.getTimestamp())))
                .andExpect(jsonPath("$[0].longest_palindrome_size", is(3)));

    }

}