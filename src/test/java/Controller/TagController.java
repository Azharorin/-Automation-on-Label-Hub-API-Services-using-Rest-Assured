package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.TagCreation;
import setup.Setup;

import java.io.IOException;

public class TagController extends Setup {

    public TagController() throws IOException {
        initConfig();
    }

    public void createTag(TagCreation tagCreation) {

       // TagCreation tagCreation = new TagCreation();
//        tagCreation.setName("prod");
//        tagCreation.setDescription("not null");
//        tagCreation.setCategory("dshdsuj");
//        tagCreation.setTask_id(1);
//        tagCreation.setShort_form("promax");
//        RestAssured.baseURI= prop.getProperty("baseURl1");
//        Response response = RestAssured.given()
//                .accept(ContentType.JSON)
//                .header("Authorization", "Bearer " + prop.getProperty("token"))
//                .body(tagCreation)
//                .when()
//                .post("")
//                        .then()
//                .assertThat().statusCode(201).extract().response();
//        System.out.println(response.asString());
//        System.out.println("Response Headers: " + response.getHeaders());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            RestAssuredConfig config = RestAssuredConfig.config().redirect(RedirectConfig.redirectConfig().followRedirects(true));

            String jsonPayload = objectMapper.writeValueAsString(tagCreation);
            System.out.println(jsonPayload);

            // Send a POST request with Rest Assured
            Response response = RestAssured
                    .given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + prop.getProperty("token1"))
                    .body(jsonPayload)
                    .config(config)
                    .when()
                    .post("http://192.168.10.233:7001/api/v1/annotation_tags")
                    .then()
                    .assertThat().statusCode(201).extract().response();




        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }


    public void createTag1(TagCreation tagCreation) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            RestAssuredConfig config = RestAssuredConfig.config().redirect(RedirectConfig.redirectConfig().followRedirects(true));
            String jsonPayload = objectMapper.writeValueAsString(tagCreation);
            System.out.println(jsonPayload);

            // Send a POST request with Rest Assured
            Response response = RestAssured.given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + prop.getProperty("token"))
                    .body(jsonPayload)
                    .config(config)
                    .post("http://192.168.10.233:7001/api/v1/annotation_tags");
                   // .then()
                    //.assertThat().statusCode(201).extract().response();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


