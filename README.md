### Challenge:

We have a weather data service that provides a bunch of information. We want to make this information more user friendly for our customers.

### Tasks:

- Write a micro service that, for a given city, returns the current temperature, air pressure and an indicator of whether you should take an umbrella with you or not.
- Give us an indication of what you think a production ready micro service should look like.
- Describe how you would deploy the application in the context of a multi-environment CI/CD pipeline. Keep in mind that we use AWS and Terraform. (We do not require an actual implementation, just a proper documentation).

### Instructions:

- Weather data should be taken from [https://openweathermap.org/api](https://openweathermap.org/api)
- You should take an umbrella if the current weather according to [https://openweathermap.org/weather-conditions](https://openweathermap.org/weather-conditions) is `Thunderstorm`, `Drizzle` or `Rain`
- The microservice should provide an HTTP API that takes a city name in the form of e.g. `Berlin` or `Berlin,de` and returns
    - the current temperature in degrees celsius
    - the current air pressure in `hPa`
    - a boolean whether to take an umbrella (`true`) or not (`false`)
- The micro service should provide an HTTP API takes a city name in the form of e.g. `Berlin` or `Berlin,de` and returns the historical data as well as an average over the last 5 queries for the same city

#### Solution

### Prerequisite:

This application uses [https://openweathermap.org/api](https://openweathermap.org/api) to access weather info. An API Key needed to generated in order to access current weather info. Once the API key is generated, please paste the API key value in the following locations :

- {root}/src/main/resources -> application.properties --> api.key
- {root}/src/test/resources -> application.properties --> api.key

### Tools:
To implement the  Weather Lookup App, I have selected following Tools

- JDK 1.8
- Maven
- Spring Boot framework for REST Microservice
- H2 DB
- Embeded Tomcat with SpringBoot framework
- JUnit Test SpringBoot Test - MockMvc, MociktoJunitRunner, SpringBootTest etc

### Database Configuration:

- H2 DB Configuration can be found or modified in application.properties under {root} -> src/main/resources
- Once Application Starts Running, H2 DB Console can be found at http://localhost:8090/h2-console/
  - DB Credential :
      - jdbc url: jdbc:h2:mem:db
      - username: sa
      - password: password

### Run the following SpringBootApplication as Maven Project From CLI:

- Run this command from root project
  >mvn clean install

- Once the above command execution gets completed, run below mentioned command to run the application:
  >mvn spring-boot:run

This will run the application in http://localhost:8090/

Note: We can change port 8090 to any desired port on src/main/resources --> application.properties (server.port)

### Run the Integration and Junit Test From CLI:
  >mvn clean test

### Swagger documentation:

- Swagger documentation of api is available at http://localhost:8090/swagger-ui.html#/

### Health Check Endpoint:

- Spring actuator health check endpoint is available at http://localhost:8090/actuator/health (GET)

### Download Postman or Google Browser to verify the REST APIS:

- Example : GET http://localhost:8090/weatherlookup/current?location=London,uk

### Thoughts On Application Design:

1) I have used H2 Database in order to get the historical search info due to time constrain and quick development. Though my choice of DB for this purpose would be Postgres because of fast retrieval speed. NoSQL like MongoDB can also be considered as this dataset does not requires to many defined relationships.

2) For future, I would also like to implement caching in this application to reduce the database call and fast retrieval of same search result. Hazelcast caching provider can considered for that because of its distributed caching and multi thread operation support.

3) Actuator health endpoint is being exposed to see the application readiness. This can be used in AWS EB to check application health.

4) Due to time constrain, I have added Integration and Junit Test in same source folder 'src/test/java'. But I would like to place them in different source folders, ex: 'src/it/java' and 'src/test/java'

5) application.resources file of test is being used to separate out test properties. I have used H2 In Memory DB for doing integration testing of the endpoint. Api key in is also being used in test for the same purpose.

### Thoughts On CI/CD Multi Environment Deployment:

**Components:**
 - Jenkins / Circle CI
 - AWS EB
 - AWS RDS
 - Terraform

## CI:
- We can implement jenkins/circle CI pipeline which will consist of stages:

 - Run compile with JUnits
 - Run Integration Test
 - Package and Store in Artifactory
 - Run Postman Automation For Functional Testing
 - Once every stages passes, It will trigger terraform based deployment in DEV

## CD

 - Terraform will be having multiple defined AWS environment info, Example: AWS EB, AWS RDS.
 - Once terraform triggers, It will deploy the jar from artifactory to AWS EB.
 - AWS EB will be having our application health check endpoint integrated to check the readiness.


 Once Testing completes in DEV, we can proceed for QA and PROD by triggering terraform for respective environment.
