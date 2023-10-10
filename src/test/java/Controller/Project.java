package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.ProjectCreate;
import org.testng.Assert;
import projectCreate.Task;
import setup.Setup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.config.RedirectConfig.redirectConfig;

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
        projectCreate.setName("ProjectName_nererere");
        projectCreate.setDescription("ProjectDescriptionss");
        projectCreate.setTasks(tasks);













        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + prop.getProperty("token"))
                .body(projectCreate)
                .when()
                .post("http://192.168.10.233:7001/api/v1/projects");

        // Check if the response is a redirect (status code 307)
        if (response.getStatusCode() == 307) {
            // Follow the redirect by getting the 'Location' header
            String redirectLocation = response.getHeader("Location");
            System.out.println("Redirect Location: " + redirectLocation);

            // Make a new request to the redirect location
            response = RestAssured.given()
                    .accept(ContentType.JSON)
                    .header("Authorization", "Bearer " + prop.getProperty("token"))
                    .body(projectCreate)
                    .when()

                    .post(redirectLocation);


        }

        // Now, check the final response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Assert the final status code and perform other validation as needed
        Assert.assertEquals(response.getStatusCode(), 201, "Expected status code 201");
    }




    }


