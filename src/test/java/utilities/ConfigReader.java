package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;

    public ConfigReader() {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return prop.getProperty(key);
    }
}	