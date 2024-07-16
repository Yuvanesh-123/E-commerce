package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClases.Utility;

public class PomRegister {
	WebDriver driver;
	public  PomRegister(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText = "Register")
	WebElement registerText;
	
	public void clickRegisterText() {
		registerText.click();
	}

	@FindBy(className = "page-title")
	WebElement tittleText;
	public String getTittleText() {
		String text = tittleText.getText();
		return text;
	}	
	
	@FindBy(id = "gender-male")
	WebElement inputRadioM;
	public void clickMaleRadiobutton() {
		inputRadioM.click();
	}
	public boolean isMaleRadioSelected() {
		boolean maleRadioselected = inputRadioM.isSelected();
		return maleRadioselected;
	}
	public void toViewGender(WebDriver driver) throws InterruptedException {
		Utility.scrollIntoView(driver, inputRadioM);
	}
	
	@FindBy(id = "gender-female")
	WebElement inputRadioR;
	public void clickFemaleRadiobutton() {
		inputRadioR.click();
	}
	public boolean isFemaleRadioSelected() {
		boolean femaleRadioselected = inputRadioR.isSelected();
		return femaleRadioselected;
	}
	
	@FindBy(id = "FirstName")
	WebElement firstNameInput;
	public boolean isfirstNameInputDisplayed() {
		boolean firstNamedisplayed = firstNameInput.isDisplayed();
		return firstNamedisplayed;
	}
	public void enterFirstName(String first) {
		firstNameInput.sendKeys(first);
	}
	public String getEnteredFirstName() {
		String enteredFirstName = firstNameInput.getAttribute("value");
		return enteredFirstName;
	}
	

}
