package baseClases;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {
	static WebDriver driver;
	static ExtentReports report;
	static String currentTimeStamp;
	
	
	
	public static void initializeWebdrivers(String browser) {
//		String Browsers = browser;
		switch (browser) {
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();			
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		
		
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			System.out.println("Driver is not initialized ");
		}
		return driver;
	}
	public static WebDriver getDriver(String Browser) {
		if (driver == null) {
			initializeWebdrivers(Browser);
		}
		return driver;
	}

	/**
	 * Initialize the ExtentReport and attaching SparkReporter in "D" drive path
	 * with TimeStamp.
	 */
	public static void initializeExtentReport() {
		Date date = new Date();	
		SimpleDateFormat formattedTime = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		currentTimeStamp = formattedTime.format(date);
		report = new ExtentReports();
		ExtentSparkReporter allTestCasesReport = new ExtentSparkReporter(
				"D:\\Eclipse\\E-commerce\\E-commerce\\Test Report\\" + currentTimeStamp
						+ "\\All_test_cases.html");
		ExtentSparkReporter passedTestCasesReport = new ExtentSparkReporter(
				"D:\\Eclipse\\E-commerce\\E-commerce\\Test Report\\" + currentTimeStamp
						+ "\\Passed_test_cases.html")
				.filter().statusFilter().as(new Status[] { Status.PASS }).apply();
		ExtentSparkReporter failedTestCasesReport = new ExtentSparkReporter(
				"D:\\Eclipse\\E-commerce\\E-commerce\\Test Report\\" + currentTimeStamp
						+ "\\Failed_test_cases.html")
				.filter().statusFilter().as(new Status[] { Status.FAIL }).apply();
		ExtentSparkReporter skipedTestCasesReport = new ExtentSparkReporter(
				"D:\\Eclipse\\E-commerce\\E-commerce\\Test Report\\" + currentTimeStamp
						+ "\\Skiped_test_cases.html")
				.filter().statusFilter().as(new Status[] { Status.SKIP }).apply();
		report.attachReporter(allTestCasesReport, passedTestCasesReport, failedTestCasesReport, skipedTestCasesReport);
	}

	public static ExtentReports getExtentReport() {
		if (report == null) {
			initializeExtentReport();
		}
		return report;
	}
	
	
	
	/**
	 * 
	 * @param testCase (ExtentTest)
	 * @param error    (AssertionError) This method will add the failure TestCases
	 *                 in the ExtentReport of both All_test_cases and
	 *                 Fail__test_cases And throw's the Assertion Error in the
	 *                 console and fail the test_cases method()
	 */
	public static void triggerAssertFail(ExtentTest test, AssertionError error, String  Fail) {
		String ScreenShot = CaptureScreenshot();
		String errormessage = error.getMessage();
		// Creating Report with throwable error
		test.fail(Fail).addScreenCaptureFromBase64String(ScreenShot, errormessage);
		// throw the error in console page
		throw new AssertionError(error);
	}
	
	
	/**
	 * 
	 * @param testCase (ExtentTest)
	 * @param e        (Exception)
	 * @throws Exception This method will add the failure TestCases in the
	 *                   ExtentReport of both All_test_cases and Fail__test_cases
	 *                   And throw's the Exception in the console and fail the
	 *                   test_cases method()
	 */
	public static void triggerExceptionFail(ExtentTest testCase, Exception e, String Fail) throws Exception {
		String ScreenShot = CaptureScreenshot();
		String errormessage = e.getMessage();
		// Creating Report with throwable error
		testCase.fail(Fail).addScreenCaptureFromBase64String(ScreenShot, errormessage);
		// throw the error in console page
		throw new Exception(e);
	}
	

	public static String CaptureScreenshot() {
		
		String Base64code = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return Base64code;
	}
	
	
	public enum Pages {
		Register, Login, Purchase
	}
	
	public static ExtentTest createTest(Pages pages, String testCaseName) {
		// Creating or getting the ExtentsReport
		ExtentReports report = getExtentReport();
		ExtentTest test;
		// returning the created test with the different description
		switch (pages) {
		case Register:
			test = report.createTest(String.format("Register - %s", testCaseName));
			test.assignCategory("Register");
			return test;

		case Login:
			test = report.createTest(String.format("Login - %s", testCaseName));
			test.assignCategory("Login");
			return test;

		case Purchase:
			test = report.createTest(String.format("Purchase - %s", testCaseName));
			test.assignCategory("Purchase");
			return test;
		

		}
		return null;
	}





}
