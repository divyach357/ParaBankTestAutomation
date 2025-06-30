package UILearnings.projects;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import UILearnings.projectsPageObjects.HomePage;

public class BaseTest {
	protected WebDriver driver;

	public WebDriver initializeDriver()
	{
	    ChromeOptions options = new ChromeOptions();
	    Map<String,Object> prefs = new HashMap<>();
	    prefs.put("profile.default_content_setting_values.popups", 2);
	    options.setExperimentalOption("prefs", prefs);
	    
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		return driver;
		
	}
	
	@BeforeMethod
	public void LoadHomePage() 
	{
		this.driver = initializeDriver();
		HomePage hp = new HomePage(driver);
		hp.GotoRegister();
	}
	
	@AfterMethod
	public void teardown() {
		 driver.close();
	}

}
