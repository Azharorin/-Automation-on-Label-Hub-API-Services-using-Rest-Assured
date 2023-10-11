package testrunner;

import Controller.CreateUserController;
import Controller.User;
import model.CreateUser;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserCreateTestRunner {

    @Test(priority =1,description = "adding new user")
    public void docreateUser() throws IOException, ConfigurationException {

        CreateUserController userController=new CreateUserController();
        userController.doCreateUser();


    }

}
