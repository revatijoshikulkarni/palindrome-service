# palindrome-service
REST API and a service to send JSON payload which has palindrome string on kafka topic

How to Run this service/application :

1. REST Endpoint taking JSON Payload and validating it :
    1. Run Application main file in this project in IntelliJ / Eclipse which will start 
    the tomcat server on localhost:8080
    2. Run the endpoint in the POSTMAN using POST request with below details,
        URL : http://localhost:8080/palindrome
        header : contenttype , application/JSON
        Body : 
        {
            	"content":"abrakadabra",
            	"timestamp":"2018-10-09 00:12:12+0100"
        }
    3. This should give below responses,
        1. If the payload is valid, it returns Status :200 Ok with text messages as "Valid message"
        2. In case of InValid body, it returns Status: 400 failed with message of what 
            is missing in the payload. 
