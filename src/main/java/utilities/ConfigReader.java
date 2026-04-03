package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;  // class-level variable

    // Constructor: loads properties from file
    public ConfigReader() {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get value of any property
    public String getValue(String key) {
        return prop.getProperty(key);
    }

    // Check if headless mode is enabled
    public boolean isHeadless() {
        String value = prop.getProperty("headless", "false"); // default false
        return Boolean.parseBoolean(value);
    }  
	
	
	
	
}	