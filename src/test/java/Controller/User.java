package Controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class MyApiCallingLogin extends Setup {
    //Properties  prop;
   // MyApiCallingLogin myApiCallingLogin;

    @Test
    public void doLogin() throws ConfigurationException, IOException {

        //myApiCallingLogin= new MyApiCallingLogin();
       // myApiCallingLogin.readConfig();
        RestAssured.baseURI= prop.getProperty("baseURL");

        String grantType = "password";
        String username = "admin@gigatech.com";
        String password = "Abc@123";
        String scope = "scope";
        String clientId = "client_id";
        String clientSecret = "client_secret";
        Response response = RestAssured.given()
                .contentType(ContentType.URLENC)

                .accept(ContentType.JSON)
                .formParam("grant_type", grantType)
                .formParam("username", username)
                .formParam("password", password)
                .formParam("scope", scope)
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .when()
                .post("/api/v1/login/access-token")
                .then()
                .assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println("Response Headers: " + response.getHeaders());


         JsonPath jsonobj = response.jsonPath();
         String token = jsonobj.get("access_token");

         System.out.println(token);






        saveEnv("token",token);
       // saveBearerToken(token);



    }
    @Test
    public void getUserme() throws IOException {
       //  myApiCallingLogin=new MyApiCallingLogin();
        // myApiCallingLogin.readConfig();
         RestAssured.baseURI= prop.getProperty("baseURL");
         Response response= RestAssured.given()
             .accept(ContentType.JSON)
             //.header("Authorization",myApiCallingLogin.prop.getProperty("token"))
             .header("Authorization", "Bearer " + prop.getProperty("token"))

             .when()
             .get("/api/v1/users/me")
             .then()
             //.extract().response();


            // .assertThat().statusCode(200).extract().response();
            .assertThat().statusCode(200).extract().response();
         System.out.println("Response Status Code: " + response.getStatusCode());
         System.out.println("Response Body: " + response.getBody().asString());

        JsonPath jsonPath= response.jsonPath();
        String name= jsonPath.get("full_name");
        System.out.println(name);


    }

    public static void saveEnv(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config= new PropertiesConfiguration("./src/test/resources/Config.properties");
        config.setProperty(key,value);
        config.save();


    }


    public void readConfig() throws IOException {



    }
    public static void main(String[] args) throws IOException {




    }






       }

