## palindrome-service
This is a REST API service that produces JSON message which has palindrome string and publishes it on the kafka topic. It also has the consumer which listens to the palindrome message and stores the payload in the postgresql database in the palindromedata table. It also has an endpoint that reads all the payload from the database and gives the response with enriched content having longest palindrome size.  

## How to Run this service/application locally on windows10:

## Prerequistes :
- Install kafka locally on windows10
- Docker is installed on windows10

1. Start kafka zookeeper and brokers locally by running the start.bat file located in kafka-setup repository

2. Run the below docker command in the command prompt to start postgresql database locally 

        Go to the directory where palindrome-service has been cloned which has docker file,
        cd C:\palindrome-service\palindrome-service\
        Run below command,
        Docker-compose up

        This will start postgresql database locally and it will create the palidrome database if not created already. It will also               create the table palindromedata if not exists. 
        Alternatively, you can also create it yourself by using the query in the script located at :
        ~\palindrome-service\palindrome-service\src\main\resources\db.migration\V1.1__create_palindrome_data_table.sql

3. REST Endpoint taking JSON Payload and validating it and publishing it on the kafka topic:

            1. Run Application main file in this project in IntelliJ / Eclipse which will start 
            the tomcat server on localhost:8081
            2. Run the endpoint in the POSTMAN using POST request with below details,
                Request : POST
                URL : http://localhost:8080/palindrome
                header : contenttype , application/JSON
                Body : 
                {
                        "content":"abrakadabra",
                        "timestamp":"2018-10-09 00:12:12+0100"
                }
            3. This should give below responses,
                1. If the payload is valid, it returns Status :200 Ok and publishes the message on the kafka topic.
                2. In case of InValid body, it returns Status: 400 failed with message of what 
                    is missing in the payload. 

 4. Rest Enpoint which gives enriched palindrome content with longest palindrome size :
    You can run this endpoint in POSTMAN using GET request
                
                        Request : GET
                        Header : contenttype as application/JSON
                        url : http://localhost:8081/getenrichedpalindrome
                        Reponse :
                            [
                                {
                                    "content": "abracadabra",
                                    "timestamp": "2018-10-09 00:12:12+0100",
                                    "longest_palindrome_size": 3
                                }
                            ]

5. Using postgresql

            After step2, it will get started postgresql run locally where you can use some client or IntelliJ to configure the database             and run the query to see the payload in the database. 

