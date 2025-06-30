package UILearnings.projectsPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy (name = "username")
	WebDriver userName;
	
	@FindBy (name = "password")
	WebDriver password;
	
	@FindBy (css = "[@type = 'submit']")
	WebDriver submitButton;
	
	@FindBy (linkText = "Register")
	WebElement registerLink;
	
	public void GotoRegister()
	
	{
		registerLink.click();
	}

}
