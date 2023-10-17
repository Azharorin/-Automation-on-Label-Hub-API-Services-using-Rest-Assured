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
        tagCreation.setName("POS");
        tagCreation.setDescription("Parts OF Speech");
        tagCreation.setCategory("Parts OF SPEECH");
        tagCreation.setTask_id(2);
        tagCreation.setShort_form("pos1");

        TagController tagController = new TagController();
        tagController.createTag(tagCreation);

    }



    }


