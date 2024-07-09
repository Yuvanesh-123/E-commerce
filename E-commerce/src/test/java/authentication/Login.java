package authentication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseClases.Helper;
import baseClases.Helper.Pages;
import pom.PomLogin;

public class Login {
	WebDriver driver;
	ExtentReports report;
	PomLogin pom;

	@BeforeClass
	public void SetUpSuit() {
		driver = Helper.getDriver();
		report = Helper.getExtentReport();
		pom =new PomLogin(driver);

	}

	public ExtentTest getReportTestCase(String testCase) {
		ExtentTest test;

		return test = Helper.createTest(Pages.Login, testCase);
	}

	@Test
	public void tC_01test_passed() throws Exception {
		ExtentTest test = this.getReportTestCase("Test pass");

		try {
			driver.get("https://demo.nopcommerce.com/");
			test.pass("The Pass test");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e);

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e);

		}
	}

	@Test
	public void tC_02test_Failed() throws Exception {
		ExtentTest test = this.getReportTestCase("Test Assertion Failed");

		try {
			throw new AssertionError();
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e);

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e);

		}
	}

	@Test
	public void tC_03test_Failed1() throws Exception {
		ExtentTest test = this.getReportTestCase("Test Exception Failed");

		try {
			throw new Exception();
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e);

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e);

		}
	}

	@Test
	public void tC_04test_Skip() throws Exception {
		ExtentTest test = this.getReportTestCase("Test Skip");

		try {
			test.skip("Test Skiped");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e);

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e);

		}
	}
	
	@Test
	public void tc_05PomTest() throws Exception {
		ExtentTest test = this.getReportTestCase("Pom Test");

		try {
			pom.clickLogInButton();
			test.pass("POM structure is complted");
		} catch (Exception e) {
			Helper.triggerExceptionFail(test, e);

		} catch (AssertionError e) {
			Helper.triggerAssertFail(test, e);

		}
		
	}

}
