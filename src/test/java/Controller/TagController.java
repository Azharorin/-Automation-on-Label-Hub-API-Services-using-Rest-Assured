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
                    //.contentType(ContentType.URLENC)
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + prop.getProperty("token"))
                    .body(jsonPayload)
                 //   .config(config)
                    .when()
                    .post("http://192.168.10.233:7001/api/v1/annotation_tags/")
                    .then()
                    .assertThat().statusCode(201).extract().response();




        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }


    public void createTag1() {

        TagCreation tagCreation = new TagCreation();
        tagCreation.setName("PoS");
        tagCreation.setDescription("Parts OF Speech");
        tagCreation.setCategory("Parts OF SPEECH");
        tagCreation.setTask_id(2);
        tagCreation.setShort_form("pos1");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            RestAssuredConfig config = RestAssuredConfig.config().redirect(RedirectConfig.redirectConfig().followRedirects(true));
            String jsonPayload = objectMapper.writeValueAsString(tagCreation);
            System.out.println(jsonPayload);

            // Send a POST request with Rest Assured
            Response response = RestAssured.given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    //.header("Authorization", "Bearer " + prop.getProperty("token"))
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Connection", "keep-alive")
                    //.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOjEsInJvbGUiOjEsImVtYWlsIjoiYWRtaW5AZ2lnYXRlY2guY29tIiwibmFtZSI6IkFdbkWluIiwiaWF0IjoxNjk3MTAzOTc4LCJ0eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjk3MTA3NTc4fQ.s6I0N661vLNRf1uVWBBpw9IUxt1_3DPz-4jRs9YN2zp1vPc60qYbbUoZ0WfTemWVCA-Zi4y6e_6Zv0bde2AUJmNi2l5YuFiQA4Q_81Chfy6QDArN7O4Ppqc-oY_Q12Ts5eDm9kuFmik5lChKj_10J5_dxlKhZVSbuEsBj4ElqFA0nJNZ3XVnr7qlz06NNH83tKAIObmI8rZsR3KsrHTy_GnVvzv-QAKvlUSC2Kj1vx3N-H_zGN61V0OI_KjPaoNJWcqaHSUUMe-Zs2CFZSKSK5jMivsWP0A0N92yImS")
                 //   .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOjEsInJvbGUiOjEsImVtYWlsIjoiYWRtaW5AZ2lnYXRlY2guY29tIiwibmFtZSI6IkFkbWluIiwiaWF0IjoxNjk3MDk1MzU0LCJ0eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjk3MDk4OTU0fQ.dN_SS8n8SWChCGnts8R5N34PwPUL6quRHWf_kPjJWeUAeLHxAgo0VycfT_BrsqE1a4ZwmDJepsETwc5lwcYlgDzWePVNnn3iP1c09uCBP4NGnPbKjObx6X1wbxPHw1T9iZjMerpBcLDzv3pmHykV-dOFM0AqOOhza2ZmOah4IKue6u7naNl-iw3Xl5aZku17W6vctOWW5x7Cv4CMDArkyZQN1rQwbxTnq3WaMV3lBEqC-k8wT8Yxr8mCPtny30DXWFC-30kV9SbB8Narkwg9sld4puIKoC5IAtUpap-BQqK_RcMcHoi8wxgaM-aAOzmF6cvhNAEEEOMFVpjZFcIrXQ")


                   // .header("Authorization", "Bearer"+ "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOjEsInJvbGUiOjEsImVtYWlsIjoiYWRtaW5AZ2lnYXRlY2guY29tIiwibmFtZSI6IkFkbWluIiwiaWF0IjoxNjk3MTAzOTc4LCJ0eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjk3MTA3NTc4fQ.s6I0N661vLNRf1uVWBBpw9IUxt1_3DPz-4jRs9YN2zp1vPc60qYbbUoZ0WfTemWVCA-Zi4y6e_6Zv0bde2AUJmNi2l5YuFiQA4Q_81Chfy6QDArN7O4Ppqc-oY_Q12Ts5eDm9kuFmik5lChKj_10J5_dxlKhZVSbuEsBj4ElqFA0nJNZ3XVnr7qlz06NNH83tKAIObmI8rZsR3KsrHTy_GnVvzv-QAKvlUSC2Kj1vx3N-H_zGN61V0OI_KjPaoNJWcqaHSUUMe-Zs2CFZSKSK5jMivsWP0A0N92yImSxjOmL2rGxhdmoalrHIgFzzxrU0INK-W61Oo3TObU-qW0Tcw")
               .header("Authorization", "Bearer " + prop.getProperty("token"))
                    .body(jsonPayload)
                    .when()
                    //.config(config)
                    .post("http://192.168.10.233:7001/api/v1/annotation_tags/")
                   .then()
                    .assertThat().statusCode(201).extract().response();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


