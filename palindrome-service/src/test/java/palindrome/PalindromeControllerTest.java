package palindrome;


import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PalindromeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestValidContent_thenCorrectResponse() throws Exception {
        MediaType applicationJsonUtf8 = new MediaType(MediaType.APPLICATION_JSON_UTF8, Charset.forName("UTF-8"));
        String message = "{\"content\": \"abrakadabra\", \"timestamp\" : \"2018-10-09 00:12:12+0100\"}";
        String content = "abrakadabra";
        String timestamp = "2018-10-09 00:12:12+0100";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/palindrome")
                .content(message)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(applicationJsonUtf8));

        JSONObject actual = new JSONObject();
        actual.put("content", content);
        actual.put("timestamp", timestamp);
        JSONAssert.assertEquals(message,actual,false);
    }

    @Test
    public void whenPostRequestInValidContent_thenCorrectResponse() throws Exception {
        String message = "{\"timestamp\" : \"2018-10-09 00:12:12+0100\"}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/palindrome")
                .content(message)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Is.is("content is mandatory")))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

}