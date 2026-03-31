package utilities;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;

public class JsonReader {
	
	
	 public static JSONArray getJsonData(String filePath) {
	        try {
	            String content = new String(Files.readAllBytes(Paths.get(filePath)));
	            return new JSONArray(content);
	        } catch (Exception e) {
	            throw new RuntimeException("JSON file read failed", e);
	        }
	    }
	

}
