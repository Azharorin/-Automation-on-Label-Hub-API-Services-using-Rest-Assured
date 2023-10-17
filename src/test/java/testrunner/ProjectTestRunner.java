package testrunner;

import Controller.*;
import javafx.scene.layout.Priority;
import model.ProjectCreate;
import model.TagCreation;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProjectTestRunner {
  //  @Test(priority = 1,description = "calling pro")
/*    public void createProject() throws IOException, ConfigurationException {
        User user=new User();
        user.doLogin();
        //pro.createProject();
        CreateUserController userController=new CreateUserController();
        userController.doCreateUser();

        ProjectCreateController controller=new ProjectCreateController();
        controller.doCreatePro();


    }*/


@Test(priority=1, description = "Admin will login by user name and password")
    public void doadminLogin() throws IOException, ConfigurationException {
        User user=new User();
        user.doLogin();
        //pro.createProject();



    }

    @Test(priority=2, description = "Admin will login by user name and password")
    public void adminInfo() throws IOException, ConfigurationException {
        User user=new User();

        user.getUserme();
        //pro.createProject();
      /*  CreateUserController userController=new CreateUserController();
        userController.doCreateUser();

        ProjectCreateController controller=new ProjectCreateController();
        controller.doCreatePro();*/




    }

    @Test(priority=3, description = "Admin will create an user")
    public void createUser() throws IOException, ConfigurationException {

        CreateUserController userController=new CreateUserController();
        userController.doCreateUser();





    }

    @Test(priority=4, description = "Admin will login by user name and password")
    public void createProject() throws IOException, ConfigurationException {

        ProjectCreateController controller=new ProjectCreateController();
        controller.doCreatePro();



    }

    @Test(priority=5, description = "Admin will create a tag for Project")
    public void createTag() throws IOException, ConfigurationException {

      /*  ProjectCreateController controller=new ProjectCreateController();
        controller.doCreatePro();*/
        TagController tagController = new TagController();
        tagController.createTag1();




    }






}
