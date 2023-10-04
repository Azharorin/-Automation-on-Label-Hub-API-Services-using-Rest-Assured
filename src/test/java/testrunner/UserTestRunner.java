package testrunner;

import Controller.User;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserTestRunner {
    @Test(priority = 1,description = "calling user login")
    public void doLogin() throws ConfigurationException, IOException {
        User user=new User();
        user.doLogin();


    }
    @Test(priority = 2,description = "calling admin info after admin login")

    public void getAdmininfo() throws IOException {
        User user = new User();
        user.getUserme();

    }

}
