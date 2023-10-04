package setup;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Setup {

    public Properties prop;
    FileInputStream file;

    @BeforeTest
    public void initConfig() throws IOException {
        prop= new Properties();
        FileInputStream file= new FileInputStream("./src/test/resources/Config.properties");
        prop.load(file);


    }

}
