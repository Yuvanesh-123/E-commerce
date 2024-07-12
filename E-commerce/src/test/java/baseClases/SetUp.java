package baseClases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {
WebDriver driver;
ExtentReports report;
	
	@BeforeSuite
	@Parameters("browser")
	public void setUp(String browser) {
		driver =Helper.getDriver(browser);
		report = Helper.getExtentReport();
		
	}
	
	@AfterSuite
	public void cleanUP () {
//		driver.quit();
//		report.flush();
		
	}
}
