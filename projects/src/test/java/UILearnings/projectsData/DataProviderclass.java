package UILearnings.projectsData;

import java.util.List;

import org.openqa.selenium.json.Json;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class DataProviderclass {
	
	@DataProvider (name = "RegistrationData")
	public  Object[][] getData() throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		List<RegistrationData> dataList = mapper.readValue(new File(System.getProperty("user.dir")+"//src//test//java//UILearnings//projectsData//RegistrationInfo.json"),
											new TypeReference<List<RegistrationData>>() {});
		
		Object[][] data = new Object[dataList.size()][1];
		
		for(int i = 0 ; i < dataList.size() ; i++)
		{
			data[i][0] = dataList.get(i);
		}
		 
			return data;
				
		}
		
	}


