package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClases.Utility;

public class PomLogin {
	WebDriver driver;
	
	
	 public PomLogin(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 @FindBy(linkText = "Log in")
	 WebElement loginText;
	 public void clickloginText() {
		 loginText.click();
		 
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
	 public boolean isEmailErrorMessageDisplayed() {
		 boolean isDisplayed =true;
		 try {
			 String errorMessage = emailError.getText();
		} catch (NoSuchElementException e) {
			isDisplayed =false;
		}return isDisplayed;
	 }
	 
	 
	 @FindBy(id ="Password")
	 WebElement passwordInput;
	 public void enterPassword (String password) {
		 passwordInput.sendKeys(password);
		
	 }
	 public String getEnteredPassword() {
		 String enteredpassword =passwordInput.getAttribute("value");
		 return enteredpassword;
	 }
	 public boolean isPasswordVisible() {
		 String attribute = passwordInput.getAttribute("type");
//		 boolean passwordVisible= true;
//		 System.out.println("attribute : "+attribute);
//		 if (attribute.equals("password") ) {
//			 passwordVisible= false;
//		 }return passwordVisible;		 
		 return !attribute.equals("password");
	 }
	 
	 
	 @FindBy(xpath = "//label[@for='Password']")
	 WebElement passwordText;
	 public String getPasswordText() {
		 String text = passwordText.getText();
		 return text;
	 }
	 
	 @FindBy(className = "login-button")
	 WebElement logInButton;
	 public String getLoginText() {
		 String loginText = logInButton.getText();
		 return loginText;
	 }
	 public void clickLogInButton() {
		 logInButton.click();
	 }
	 public void toViewLoginButton(WebDriver driver ) throws InterruptedException {
		 Utility.scrollIntoView(driver, logInButton);
	 }
	 
	 @FindBy(className = "message-error")
	 WebElement loginError;
	 public String getErrorMessage() {
		 String errorMessage = loginError.getText();
		 return errorMessage;
	 }
	 @FindBy(linkText = "Log out")
	 WebElement logOutText;
	public void clickLogOutText() {
		logOutText.click();
	}
	public String getLogOutText() {
		String textLogOut = logOutText.getText();
		return textLogOut;
	}
}
