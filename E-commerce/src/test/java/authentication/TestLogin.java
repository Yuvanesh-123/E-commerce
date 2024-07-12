package authentication;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
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
	public void classSetup() {
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
		ExtentTest test = this.getReportTestCase(" Verify the \"Welcome, Please Sign In!\" text is presented or not");

		try {
			driver.get("https://demo.nopcommerce.com/");
			pom.clickloginText();
			String tittleText = pom.getTittleText();
			Assert.assertEquals(tittleText, "Welcome, Please Sign In!");
			test.pass("The \"Welcome, Please Sign In!\" text is presented in the Login Page");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_01 Page Tittle");
		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_01The Text is not presented or mismatched");

		}
	}

	@Test
	public void Tc_02() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the \"Email:\" text is presented or not");

		try {
			String emailText = pom.getEmailText();
			Assert.assertEquals(emailText, "Email:");
			test.pass("The Email text is presented");
		} catch (NoSuchElementException e) {
			Helper.triggerExceptionFail(test, e, "In Tc_02 Email Field's Text is not presented");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_02 The Text is mismatched");

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
		ExtentTest test = this
				.getReportTestCase("Verify the Email Input Field is enterable for Special Charactes or not");

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
		ExtentTest test = this
				.getReportTestCase("Verify the \"Please enter a valid email address.\" error text is displayed or not");

		try {
			pom.clickEmailText();
			String errorMessage = pom.getEmailErrorMessage();
			Assert.assertEquals(errorMessage, "Please enter a valid email address.");
			System.out.println(errorMessage);
			test.pass(
					"The \"Please enter a valid email address.\" error message is displayed when the email is invalid");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_07 while getting error message");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_07 The error text is not displayed or mismatched");
		}
	}

	@Test
	public void Tc_08() throws Exception {
		ExtentTest test = this
				.getReportTestCase("Verify the \"Please enter your email\" error text is displayed or not");

		try {
			pom.enterEmail(Keys.CONTROL, "a", Keys.DELETE);
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

	@Test
	public void Tc_09() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the \"Password:\" text is presented or not");

		try {
			String passwordText = pom.getPasswordText();
			Assert.assertEquals(passwordText, "Password:");
			test.pass("The password text is presented");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_09 The Password text is not displayed");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, " In Tc_09 The text is mismatched");

		}

	}

	@Test
	public void Tc_10() throws Exception {
		ExtentTest test = this
				.getReportTestCase("Verify the Password Input Field is enterable for all characters or not");

		try {
			pom.enterPassword("test typing@!#$%^&*1234567");
			String enterText = pom.getEnteredPassword();
			System.out.println(enterText);
			Assert.assertEquals(enterText, "test typing@!#$%^&*1234567");
			test.pass("The Password field is enterable 	");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_03 While entering email");
		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_03 entered text is not same in the email Field");
		}
	}

	@Test
	public void Tc_11() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the Password Input Field's entered text is visible or not");

		try {
			boolean isPasswordVisible = pom.isPasswordVisible();
			System.out.println("isPasswordVisible : "+isPasswordVisible);
			Assert.assertEquals(isPasswordVisible, false);
			test.pass("The Password field's entered text is not visible");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_11 the exception in Pom Class ");
		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_03 The Password is visible ");
		}
	}
	
	@Test
	@Parameters("Email")
	public void Tc_12(String Email) throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the Error message displayed when entered valid email");

		try {
			pom.enterEmail(Email);
			boolean emailErrorMessageDisplayed = pom.isEmailErrorMessageDisplayed();
			Assert.assertEquals(emailErrorMessageDisplayed, false);
			test.pass("The Error message is not  display when entered valid email ");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, "In Tc_12 The exception  in Pom class");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "The Error message displayed when entered valid email ");

		}

	}
	
	@Test
	public void Tc_13() throws Exception {
		ExtentTest test = this.getReportTestCase("Verify the Login button & Login text is displayed or not");

		try {
			String loginText = pom.getLoginText();
			Assert.assertEquals(loginText, "LOG IN");

			test.pass("The LOG IN button is displayed and the text is "+loginText);
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e, " In Tc_13 The login button is not displayed");

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e, "In Tc_13 The login button is not displayed ");

		}

	}
	
	
//	
}
