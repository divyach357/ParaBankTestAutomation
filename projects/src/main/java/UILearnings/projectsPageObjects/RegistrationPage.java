package UILearnings.projectsPageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy (id = "customer.firstName")
	WebElement firstName;
	
	@FindBy (id = "customer.lastName")
	WebElement lastName;
	
	@FindBy (id = "customer.address.street")
	WebElement address;
	
	@FindBy (id = "customer.address.city")
	WebElement city;
	
	@FindBy (id = "customer.address.state")
	WebElement state;
	
	@FindBy (id = "customer.address.zipCode")
	WebElement zipCode;
	
	@FindBy (id = "customer.phoneNumber")
	WebElement phoneNumber;
	
	@FindBy (id = "customer.ssn")
	WebElement ssn;
	
	@FindBy (id = "customer.username")
	WebElement username;
	
	@FindBy (id = "customer.password")
	WebElement password;
	
	@FindBy (id = "repeatedPassword")
	WebElement repeatedPassword;
	
	@FindBy (css = "[value = 'Register']")
	WebElement submitRegistration;
	
	private static final Map<String,By> errorLocators = new HashMap<>();
	static {
		errorLocators.put("firstName",By.id("customer.firstName.errors"));
		errorLocators.put("lastName",By.id("customer.lastName.errors"));
		errorLocators.put("address",By.id("customer.address.street.errors"));
		errorLocators.put("city",By.id("customer.address.city.errors"));
		errorLocators.put("state",By.id("customer.address.state.errors"));
		errorLocators.put("zipCode",By.id("customer.address.zipCode.errors"));
		errorLocators.put("ssn",By.id("customer.ssn.errors"));
		errorLocators.put("username",By.id("customer.username.errors"));
		errorLocators.put("password",By.id("customer.password.errors"));
		errorLocators.put("confirmpassword",By.id("repeatedPassword.errors"));


	}
	public String getErrorMessage(String fieldName) {
        By locator = errorLocators.get(fieldName);
        if (locator == null) {
            throw new IllegalArgumentException("No error locator defined for field: " + fieldName);
        }
        return driver.findElement(locator).getText();
    }
		
	public void fillField(String fieldName, String value) {
        
		switch (fieldName) {
            case "firstName":
                firstName.sendKeys(value);
                break;
            case "lastName":
                lastName.sendKeys(value);
                break;
            case "address":
            	address.sendKeys(value);
                break;
            case "city":
            	city.sendKeys(value);
                break;
            case "state":
            	state.sendKeys(value);
                break;
            case "zipCode":
            	zipCode.sendKeys(value);
                break;
            case "phoneNumber":
            	phoneNumber.sendKeys(value);
                break;
            case "ssn":
            	ssn.sendKeys(value);
                break;
            case "username":
                username.sendKeys(value);
                break;
            case "password":
                password.sendKeys(value);
                break;
            case "repeatedPassword":
                repeatedPassword.sendKeys(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
	}
	public void FormElementClick() {
		firstName.click();
		
	}
	public void SubmitForm() {
		submitRegistration.click();
		
	}
}
