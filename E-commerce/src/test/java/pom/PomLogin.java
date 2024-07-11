package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLogin {
	WebDriver driver;
	
	
	 public PomLogin(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 @FindBy(linkText = "Log in")
	 WebElement logInButton;
	 public void clickLogInButton() {
		 logInButton.click();
		 
	 }
	 
	 
	 
	 @FindBy(className = "page-title")
	 WebElement tittleText;
	 
	 public String getTittleText() {
		String text= tittleText.getText();
		return text;
	 }
	 
	 @FindBy(xpath = "//label[@for='Email']")
	 WebElement emailText;
	 public String  getEmailText() {
		String text = emailText.getText();
		return text;		
	 }
	 public void clickEmailText() {
		 emailText.click();
	 }
	 
	 @FindBy(id = "Email")
	 WebElement emailInput;
	 public void enterEmail(String email) {
		 emailInput.sendKeys(email);
//		 emailInput.sendKeys(Keys.BACK_SPACE);
	 }
	 public void enterEmail(Keys keys, String a, Keys key) {
//		 emailInput.sendKeys(email);
		 emailInput.sendKeys(keys, a, key);
	 }
	 public String getEnteremail() {
		 String enteredValue = emailInput.getAttribute("value");
		 return enteredValue;
	 }
	 public void clearEmailField() {
		 emailInput.clear();
	 }
	 
	 @FindBy(id ="Email-error")
	 WebElement emailError;
	 public String getEmailErrorMessage() {
		 String errorMessage = emailError.getText();
		 return errorMessage;
	 }
	 
	 
	 @FindBy(id ="Password")
	 WebElement passwordInput;
	 
	 

}
