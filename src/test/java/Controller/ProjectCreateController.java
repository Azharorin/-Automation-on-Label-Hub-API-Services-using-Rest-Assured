package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.ProjectModel;
import model.TaskModel;
//import org.json.JSONObject;
import org.testng.Assert;
import setup.Setup;

import java.io.IOException;
import java.util.*;

public class ProjectCreateController extends Setup {

    public ProjectCreateController() throws IOException {
        initConfig();
    }
    public void doCreatePro() {
        try {
            TaskModel task = new TaskModel();
            task.setId(1);
            ArrayList<Integer> tags = new ArrayList<>(Arrays.asList(1));
            task.setTags(tags);

            ProjectModel project = new ProjectModel();
            project.setName("project_tree");
            project.setDescription("string");
            ArrayList<TaskModel> taskList = new ArrayList<>(Arrays.asList(task));
            project.setTasks(taskList);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(project);

            // Create the request specification
            RequestSpecification reqSpec = RestAssured.given();
            reqSpec.contentType(ContentType.JSON);
           // reqSpec.header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOjEsInJvbGUiOjEsImVtYWlsIjoiYWRtaW5AZ2lnYXRlY2guY29tIiwibmFtZSI6IkFkbWluIiwiaWF0IjoxNjk3MTM4MjQ1LCJ0eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjk3MTQxODQ1fQ.lDI2BbFD47o8Ooe7xovjYgy2dLXnfnxcznJxz1Z6QcSfyA9jRyQ-XZALGyJlvBGhyfVrUxlevByYwGiOHArXCdrd6FZczfKGWx_mnqISgEal8uzyAPnHU4V4h3AVj2aCzbGnIh1SkZ5aHsnqJN-s7QXQT6xTUcsjutEzebVs57tlCno9LUZxlzGKq5zAGYs3ROBCxqEl8UlbvpzasBpr0l1ta2pWQCp_nERZCrhgwdIAC6F2VaUJHbeSQnk_4mWQVbLBv_o56-qejzoZVUBG99Iv6FigNofDVJW-GjL9B3mYGLOSrwEAfgQ7VweCuJ1ZQRlS88JM-3PK3ag93pxg0w"); // Replace with your actual token
       reqSpec.header("Authorization", "Bearer " + prop.getProperty("token"));

            // Send the POST request to the specific URL
            Response response = reqSpec
                    .body(jsonPayload)
                    .when()
                    .post("http://192.168.10.233:7001/api/v1/projects/"); // Adjust the URL as needed

            response.prettyPrint();

            // Validate the response
            Assert.assertEquals(201, response.getStatusCode(), "Response code should be 201");

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }








    }








