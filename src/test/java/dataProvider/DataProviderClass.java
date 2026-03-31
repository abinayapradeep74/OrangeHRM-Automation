package dataProvider;

import org.json.JSONArray;
import org.testng.annotations.DataProvider;

import utilities.JsonReader;

public class DataProviderClass {
	
	 @DataProvider(name = "addEmployeeData")
	    public Object[][] getData() {

	        String path = System.getProperty("user.dir") + "/src/test/resources/addEmployee.json";
	        JSONArray jsonArray = JsonReader.getJsonData(path);

	        Object[][] data = new Object[jsonArray.length()][1];

	        for (int i = 0; i < jsonArray.length(); i++) {
	            data[i][0] = jsonArray.getJSONObject(i);
	        }

	        return data;
	    }
	}
	
	


