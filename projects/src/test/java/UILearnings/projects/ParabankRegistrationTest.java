package UILearnings.projects;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import UILearnings.projectsData.DataProviderclass;
import UILearnings.projectsData.RegistrationData;
import UILearnings.projectsPageObjects.RegistrationPage;

public class ParabankRegistrationTest extends BaseTest{
	
	@Test( dataProvider = "RegistrationData",dataProviderClass = DataProviderclass.class)
	public void testRegistration(RegistrationData data) throws InterruptedException

	{ 	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		RegistrationPage registrationdetails = new RegistrationPage(driver);
		
		registrationdetails.FormElementClick();
		registrationdetails.fillField("firstName",data.firstName);
		registrationdetails.fillField("lastName",data.lastName);
		registrationdetails.fillField("address",data.address);
		registrationdetails.fillField("city",data.city);
		registrationdetails.fillField("state",data.state);
		registrationdetails.fillField("zipCode",data.zipCode);
		registrationdetails.fillField("phoneNumber",data.phone);
		registrationdetails.fillField("ssn",data.ssn);
		registrationdetails.fillField("username",data.username);
		registrationdetails.fillField("password",data.password);
		registrationdetails.fillField("repeatedPassword",data.confirmpassword);
		registrationdetails.SubmitForm();
		
		String errorMessage = registrationdetails.getErrorMessage(data.field);	
		assertEquals(errorMessage, data.expectedError);
		
	}
	
	
	

}
