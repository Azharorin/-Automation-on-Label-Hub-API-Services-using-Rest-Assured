package testrunner;

import Controller.TagController;
import Controller.User;
import model.TagCreation;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TagCreateTestRunner {
    @Test
    public void createTags() throws ConfigurationException, IOException {
//        User user = new User();
//        user.doLogin();

        TagCreation tagCreation = new TagCreation();
        tagCreation.setName("prodss");
        tagCreation.setDescription("not null");
        tagCreation.setCategory("dshdsuj");
        tagCreation.setTask_id(1);
        tagCreation.setShort_form("promax");

        TagController tagController = new TagController();
        tagController.createTag1(tagCreation);

    }



    }


