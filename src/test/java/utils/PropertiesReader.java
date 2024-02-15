package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties testProps;

    public PropertiesReader(String propFile) {
        this.testProps = new Properties();
        try {
            testProps.load(new FileInputStream(propFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBaseURL(){
        return testProps.getProperty("base_url");
    }

    public String getAPIkey(){
        return testProps.getProperty("mailsac_api_key");
    }
}
