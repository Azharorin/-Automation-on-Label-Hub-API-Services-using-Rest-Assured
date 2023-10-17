package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.ProjectCreate;
import model.Task;
import setup.Setup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {




    public class Project extends Setup {

        public Project() throws IOException {
            initConfig();

        }


        public void createProject() throws JsonProcessingException {


            List<Integer> tags = new ArrayList<>();
            tags.add(1);

            // Create a task
            Task task1 = new Task();
            task1.setId(1);
            task1.setTags(tags);

            // Create a list of tasks and add task1 to it
            List<Task> tasks = new ArrayList<>();
            tasks.add(task1);

            // Create a ProjectCreate object
            ProjectCreate projectCreate = new ProjectCreate();
            projectCreate.setName("ProjectNamdde_nerererewe");
            projectCreate.setDescription("ProjectDdfdescriptionss");
            projectCreate.setTasks(tasks);
            ;
            //  String jsonp = null;
            String jsonp = null;
            try {
                // Create an ObjectMapper
                ObjectMapper objectMapper = new ObjectMapper();

                // Serialize the Root object to JSON
                jsonp = objectMapper.writeValueAsString(projectCreate);

                // Print the JSON
                System.out.println(jsonp);
            } catch (Exception e) {
                e.printStackTrace();
            }


            Response response = RestAssured.given()
//                .accept(ContentType.JSON)
                    .header("Authorization", "Bearer " + prop.getProperty("token"))
                    .body(jsonp)
                    .when()
                    .post("http://corpus-dev.gigatechltd.com/labelhub/project-service/api/v1/projects/");

            // Check if the response is a redirect (status code 307)
            if (response.getStatusCode() == 307) {
                // Follow the redirect by getting the 'Location' header
                String redirectLocation = response.getHeader("Location");
                System.out.println("Redirect Location: " + redirectLocation);

                // Make a new request to the redirect location
                response = RestAssured.given()
                        .accept(ContentType.JSON)
                        .header("Authorization", "Bearer " + prop.getProperty("token"))
                        .body(jsonp)
                        .when()

                        .post(redirectLocation);


            }

            //Now, check the final response
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

            // Assert the final status code and perform other validation as needed
//        Assert.assertEquals(response.getStatusCode(), 201, "Expected status code 201");


//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            RestAssuredConfig config = RestAssuredConfig.config().redirect(RedirectConfig.redirectConfig().followRedirects(true));
//
//           String jsonPayload = objectMapper.writeValueAsString(projectCreate);
//           System.out.println(jsonPayload);
//
//            // Send a POST request with Rest Assured
//            Response response = RestAssured.given()
//                    .accept(ContentType.JSON)
//                    .contentType(ContentType.JSON)
//                    .header("Authorization", "Bearer " + prop.getProperty("token"))
//                    .body(projectCreate)
//                    .config(config)
//                    .post("http://192.168.10.233:7001/api/v1/projects");


            // Handle the response
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

//        // You can add additional assertions or validations here
//    } catch ( JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }


      /*  public void createProject1 () throws JsonProcessingException {

            List<Integer> tags = new ArrayList<>();
            tags.add(1);

            // Create a task
            Task task1 = new Task();
            task1.setId(1);
            task1.setTags(tags);

            // Create a list of tasks and add task1 to it
            List<Task> tasks = new ArrayList<>();
            tasks.add(task1);

            // Create a ProjectCreate object
            ProjectCreate projectCreate = new ProjectCreate();
            projectCreate.setName("ProjectNamdde_nererere");
            projectCreate.setDescription("ProjectDdfdescriptionss");
            projectCreate.setTasks(tasks);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                RestAssuredConfig config = RestAssuredConfig.config().redirect(RedirectConfig.redirectConfig().followRedirects(true));

                String jsonPayload = objectMapper.writeValueAsString(projectCreate);
                System.out.println(jsonPayload);

                Response response = RestAssured.given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + prop.getProperty("token"))
                        .body(jsonPayload)
                        .config(config)
                        .post("http://192.168.10.233:7001/api/v1/projects");

                // Handle the response
                System.out.println("Response Status Code: " + response.getStatusCode());
                System.out.println("Response Body: " + response.getBody().asString());

                if (response.getStatusCode() == 307) {
                    // Follow the redirect by getting the 'Location' header
                    String redirectLocation = response.getHeader("Location");
                    System.out.println("Redirect Location: " + redirectLocation);

                    // Make a new request to the redirect location
                    response = RestAssured.given()
                            .accept(ContentType.JSON)
                            .contentType(ContentType.JSON)
                            .header("Authorization", "Bearer " + prop.getProperty("token"))
                            .body(jsonPayload)
                            .config(config)
                            .post(redirectLocation);
                }

                // You can add additional assertions or validations here
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
*/

        }
    }













}
