package baseClases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	
	
	public static void scrollIntoView(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Going to Start");
		js.executeScript("arguments[0].scrollIntoView({behavior:\"smooth\",block:\"center\",inline:\"center\"})",element);
//		Thread.sleep(2000);
		System.out.println("Start to Validating");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
	}

}
