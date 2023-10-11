package testrunner;

import Controller.Project;
import Controller.User;
import model.ProjectCreate;
import model.TagCreation;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProjectTestRunner {
    @Test(priority = 1,description = "calling pro")
    public void createProject() throws IOException, ConfigurationException {
        User user=new User();
      user.doLogin();
        Project pro=new Project();
        //pro.createProject();
        pro.createProject();

    }
}
