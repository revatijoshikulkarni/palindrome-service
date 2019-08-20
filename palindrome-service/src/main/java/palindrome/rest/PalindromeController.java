package palindrome.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import palindrome.domain.Palindrome;
import palindrome.kafka.PalindromeSendService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PalindromeController {

    private final Palindrome palindrome;
    private final PalindromeSendService service;
    private final PalindromeHelper palindromeHelper;

    @ApiOperation(value = "Validates the message and publishes it on the topic",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully send the message"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @RequestMapping(
            value = "/palindrome",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void sendMessage(
            @ApiParam(value = "Message content", required = true)
            @Valid @RequestBody Palindrome content)
    {
        palindrome.setTimestamp(content.getTimestamp());
        palindrome.setContent(content.getContent());
        Palindrome palindromeMessage = Palindrome.builder()
                .content(content.getContent())
                .timestamp(content.getTimestamp())
                .build();
        service.send(palindromeMessage);
        //return ResponseEntity.ok("Valid Message");
    }

    @ApiOperation(value = "Fetches the messages from database and produces JSON value",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the message"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @RequestMapping(
            value = "/getenrichedpalindrome",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Palindrome> getMessage()
    {
        return palindromeHelper.getUpdatedPalindromeData();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
