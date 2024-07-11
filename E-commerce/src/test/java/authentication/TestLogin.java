package authentication;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.base.Function;

import baseClases.Helper;
import baseClases.Helper.Pages;
import pom.PomLogin;

public class TestLogin {
	WebDriver driver;
	ExtentReports report;
	PomLogin pom;

	@BeforeClass
	public void SetUpSuit() {
		driver = Helper.getDriver();
		report = Helper.getExtentReport();
		pom = new PomLogin(driver);

	}

	public ExtentTest getReportTestCase(String testCase) {
		ExtentTest test;
		return test = Helper.createTest(Pages.Login, testCase);
	}

	@Test
	public void Tc_01() throws Exception {
		ExtentTest test = this.getReportTestCase("Tc_01 Verify the \"Welcome, Please Sign In!\" text is presented or not");

		try {
			driver.get("https://demo.nopcommerce.com/");
			pom.clickLogInButton();		
			String tittleText = pom.getTittleText();
			Assert.assertEquals(tittleText, "Welcome, Please Sign In!");
			test.pass("The \"Welcome, Please Sign In!\" text is presented in the Login Page");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_01 Page Tittle");
		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "The Text is not presented or mismatched");

		}
	}

	@Test
	public void Tc_02() throws Exception {
		ExtentTest test = this.getReportTestCase("Tc_02 Verify the \"Email:\" text is presented or not");

		try {
			String emailText = pom.getEmailText();
			Assert.assertEquals(emailText, "Email:");
			test.pass("The Email text is presented");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Email Field's Text");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "");

		}
	}

	@Test
	public void Tc_03() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the Email Input Field is enterable for alphabet or not");

		try {
			pom.enterEmail("test typing");
			String enterText = pom.getEnteremail();
			Assert.assertEquals(enterText, "test typing");
			test.pass("The Email field is enterable for alphabet");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_03 While entering email");
		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_03 entered text is not same in the email Field");

		}
	}

@Test
public void Tc_04() throws Exception {
	ExtentTest test = this.getReportTestCase("Verify the Error message displayed when entered Invalid email");

	try {
		pom.clearEmailField();
		pom.enterEmail("1234abc@g");
		String emailErrorMessage = pom.getEmailErrorMessage();
		Assert.assertEquals(emailErrorMessage, "Wrong email");
		test.pass("The error message is displayed ");
	} catch (Exception e) {
		Helper.triggerExceptionFail(test, e, "In Tc_04 The error msg is not displayed");

	} catch (AssertionError e) {
		Helper.triggerAssertFail(test, e, "In Tc_04 the error message is null or mismatched");

	}

}
	@Test
	public void Tc_05() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the Email Input Field is enterable for Numeric or not");

		try {
			pom.clearEmailField();
			pom.enterEmail("12345678");
			String enterNumbers = pom.getEnteremail();
			Assert.assertEquals(enterNumbers, "12345678");
			test.pass("The Email field is enterable for Numeric");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_05 while entering and getting the text");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_05 Email Input Field is not enterable for Numeric");

		}
	}
	
	@Test
	public void Tc_06() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the Email Input Field is enterable for Special Charactes or not");

		try {
			pom.clearEmailField();
			pom.enterEmail("!@#$%^&*");
	 		String enterNumbers = pom.getEnteremail();
			Assert.assertEquals(enterNumbers, "!@#$%^&*");
			test.pass("The Email field is enterable for Special Charactes");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_06 while entering and getting the text");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_06  Email Input Field is not enterable for Special Characters ");

		}
	}
	
	@Test
	public void Tc_07() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the \"Please enter a valid email address.\" error text is displayed or not");
		
		try {
			pom.clickEmailText();
			String errorMessage = pom.getEmailErrorMessage();
			Assert.assertEquals(errorMessage, "Please enter a valid email address.");
			System.out.println(errorMessage);
			test.pass("The \"Please enter a valid email address.\" error message is displayed when the email is invalid");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_07 while getting error message");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_07 The error text is not displayed or mismatched");
		}
	}
	@Test
	public void Tc_08() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the \"Please enter your email\" error text is displayed or not");
		
		try {
			pom.enterEmail(Keys.CONTROL,"a",Keys.DELETE);
			String emailErrorMessage = pom.getEmailErrorMessage();
			Assert.assertEquals(emailErrorMessage, "Please enter your email"); 
			System.out.println(emailErrorMessage);
			test.pass("The \"Please enter your email\" error message is displayed when the email is invalid");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_08 while getting error message");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_08 The error text is not displayed or mismatched");

		}

	}
	



}
