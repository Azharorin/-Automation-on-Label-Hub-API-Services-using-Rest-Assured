package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.ProjectCreate;
import org.testng.Assert;
import model.Task;
import setup.Setup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Project extends Setup {

    public Project() throws IOException {
        initConfig();

    }


    public void createProject() throws JsonProcessingException {




        // Create a task
        Task task1 = new Task();
        task1.setId(1);
        List<Integer> tags = new ArrayList<>();
        tags.add(1);
        task1.setTags(tags);

        // Create a list of tasks and add task1 to it
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);

        // Create a ProjectCreate object
        ProjectCreate projectCreate = new ProjectCreate();
        projectCreate.setName("niloy lal");
        projectCreate.setDescription("ProjectDdfdescriptionss");
        projectCreate.setTasks(tasks);
        ;
       // String jsonp = null;
        //String jsonp = null;
        try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Serialize the Root object to JSON
            String jsonp = objectMapper.writeValueAsString(projectCreate);

            // Print the JSON
            System.out.println(jsonp);

            Response response = RestAssured.given()
//                .accept(ContentType.JSON)
                    //.header("Authorization", "Bearer " + prop.getProperty("token"))
                    .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOjEsInJvbGUiOjEsImVtYWlsIjoiYWRtaW5AZ2lnYXRlY2guY29tIiwibmFtZSI6IkFkbWluIiwiaWF0IjoxNjk3MDg1NjUzLCJ0eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjk3MDg5MjUzfQ.Rf0RLyFlgtrNkoJf5sDkCP8wyclTQECOS6_ZdizIWbmi0LbDpPIW83o3lKfNaCv8tBvbce5uiylgesCdaaVegQThVwpolt0jfOoYevteoWIutcnJkuuGXrXYas5WCzslgIeGNVeu6GMIcuGUyT-I06nvHwFFJ86h6sjyyvZ3Vj_bWIlZSkLlxK8WRFXuOwtwwlixVaQyrUPBALWo0SOK2jQV6lgpiwTP2RSrWw5AEA4cwNk3_YJQGtFBG030Y1pWLQ5MxAF1mq5v7BYeJjIu5D-yYZ8It0fOFDu3-b-YF1RMoWoVQbnyR2-bY7pwkZvTEBW1AOwXnr5pocjWxbP9tg")

                    .body(projectCreate)
                    .when()
                    .post("http://192.168.10.233:7001/api/v1/projects/")
                    .then()
                    .assertThat().statusCode(201).extract().response();
        } catch (Exception e) {
            e.printStackTrace();
        }




        // Check if the response is a redirect (status code 307)
//        if (response.getStatusCode() == 307) {
//            // Follow the redirect by getting the 'Location' header
//            String redirectLocation = response.getHeader("Location");
//            System.out.println("Redirect Location: " + redirectLocation);
//
//            // Make a new request to the redirect location
//            response = RestAssured.given()
//                    .accept(ContentType.JSON)
//                    .header("Authorization", "Bearer " + prop.getProperty("token"))
//                    .body(projectCreate)
//                    .when()
//
//                    .post(redirectLocation);
//
//
//        }
//
//        //Now, check the final response
//        System.out.println("Response Status Code: " + response.getStatusCode());
//        System.out.println("Response Body: " + response.getBody().asString());

    }
}











