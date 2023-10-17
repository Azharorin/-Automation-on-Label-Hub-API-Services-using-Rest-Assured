package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CreateUser;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

public class CreateUserController extends Setup {

    public CreateUserController() throws IOException {
        initConfig();
    }


    public void doCreateUser(){
        Response response;

       CreateUser user= new CreateUser("allnus","aqi@gmail.com",2,"01819095832","2003-10-11","Male","DHAKA","BSC",2,"Abc@123");

        //RestAssured.baseURI= prop.getProperty("baseURL");
        //System.out.println(user);
//        Response response= RestAssured.given()
//                .accept(ContentType.JSON)
//                //.header("Authorization",myApiCallingLogin.prop.getProperty("token"))
//                .header("Authorization", "Bearer " + prop.getProperty("token"))
//                .body(user)
//
//                .when()
//                .post("api/v1/users")
//                .then()
//                //.extract().response();
//
//
//                // .assertThat().statusCode(200).extract().response();
//                .assertThat().statusCode(201).extract().response();



        ObjectMapper objectMapper = new ObjectMapper();
        try {
            RestAssuredConfig config = RestAssuredConfig.config().redirect(RedirectConfig.redirectConfig().followRedirects(true));

            String jsonPayload = objectMapper.writeValueAsString(user);
            System.out.println(jsonPayload);

            response = RestAssured
                    .given()
                    .contentType(ContentType.URLENC)
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)

                    .header("Authorization", "Bearer " + prop.getProperty("token"))
                    .body(jsonPayload)
                    .config(config)

                    .when()
                    .post("http://192.168.10.233:7012/api/v1/users/")
            .then()
                    .assertThat().statusCode(200).extract().response();
            // Send a POST request with Rest Assured
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());
           /* if (response.getStatusCode() == 307) {
                // Follow the redirect by getting the 'Location' header
                String redirectLocation = response.getHeader("Location");
                System.out.println("Redirect Location: " + redirectLocation);

                // Make a new request to the redirect location
                response = RestAssured.given()
                        .accept(ContentType.JSON)
                        .header("Authorization", "Bearer " + prop.getProperty("token"))
                        .body(jsonPayload)
                        .when()

                        .post(redirectLocation);

*/







        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }



    }





}



