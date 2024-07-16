package authentication;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import baseClases.Helper;
import baseClases.Helper.Pages;
import pom.PomRegister;

public class TestRegister {
	WebDriver driver;
	ExtentReports report;
	PomRegister pom;

	@BeforeClass
	public void classSetup() {
		driver = Helper.getDriver();
		report = Helper.getExtentReport();
		pom = new PomRegister(driver);

	}
	
	public ExtentTest getReportTestCase(String testCase) {
		ExtentTest test;
		return test= Helper.createTest(Pages.Register, testCase );
	}
	
	@Test
	public void Tc_01() throws Exception {
		ExtentTest test = this.getReportTestCase(" Verify the \"Register\" text is presented or not");

		try {
			pom.clickRegisterText();;
			String tittleText = pom.getTittleText();
			Assert.assertEquals(tittleText, "Register");
			test.pass("The \"Register\" text is presented in the Login Page");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_01 Page Tittle");
		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_01The Text is not presented or mismatched");

		}
	}
	
	@Test
	public void Tc_02() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the Gender-Male Radio button is selectable or not");

		try {
			pom.toViewGender(driver);
			pom.clickMaleRadiobutton();
			boolean maleRadioSelected = pom.isMaleRadioSelected();
			Assert.assertEquals(maleRadioSelected, true);
			test.pass("The Male radio button is Selectable ");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, " In Tc_02 the button is nonSelectable");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_02 the button is not selected ");

		}

	}
	@Test
	public void Tc_03() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the Gender-Female Radio button is selectable or not");

		try {
			
			pom.clickFemaleRadiobutton();
			boolean femaleRadioSelected = pom.isFemaleRadioSelected();
			Assert.assertEquals(femaleRadioSelected, true);
			test.pass("The Female radio button is Selectable ");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, " In Tc_03 the button is nonSelectable");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_03 the button is not selected ");

		}

	}
	
	
	@Test
	public void Tc_04() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the  First Name Input field is displayed or not ");

		try {
			boolean isfirstNameInputDisplayed = pom.isfirstNameInputDisplayed();
			Assert.assertEquals(isfirstNameInputDisplayed, true);
			test.pass("The FirstName input field is displayed");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_04 The FirstName fiels is not displayed ");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, " In Tc_04 The FirstName fiels is not displayed");

		}

	}
	@Test
	public void Tc_05() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the FirstName field is enterable or not");

		try {
			pom.enterFirstName("ABcd@!123");
			String enteredFirstName = pom.getEnteredFirstName();
			Assert.assertEquals(enteredFirstName, "ABcd@!123");
			test.pass("The FirstName field is enterable for all characters");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_05  FirstName field is not enterable ");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_05 Some characters are not enterable ");

		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
