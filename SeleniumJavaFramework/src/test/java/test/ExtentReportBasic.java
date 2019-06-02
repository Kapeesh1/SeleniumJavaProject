package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasic {

	private static WebDriver driver= null;
	public static void main(String[] args) {

		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test = extent.createTest("Google Search Test", "This is google test search validation functionality");

		WebDriverManager.chromedriver().version("2.4").setup();
		driver = new ChromeDriver();

		test.log(Status.INFO, "Starting test case");
		driver.get("http://google.com");
		test.pass("Navigate to google.com");
		driver.findElement(By.name("q")).sendKeys("Facebook.com");
		test.pass("Enter text in search box");
		WebElement elem= driver.findElement(By.name("btnK"));
		elem.submit();
		test.pass("Press keyboard enter key");

		driver.close();
		driver.quit();
		test.pass("closed the browser");

		test.info("test completed");


		ExtentTest test2 = extent.createTest("Google Search Test two", "This is google test search validation functionality");

		WebDriverManager.chromedriver().version("2.4").setup();
		driver = new ChromeDriver();

		test2.log(Status.INFO, "Starting test case");
		driver.get("http://google.com");
		test2.pass("Navigate to google.com");
		driver.findElement(By.name("q")).sendKeys("Facebook.com");
		test2.pass("Enter text in search box");
		elem= driver.findElement(By.name("btnK"));
		elem.submit();
		test2.fail("Press keyboard enter key");

		driver.close();
		driver.quit();
		test.pass("closed the browser");

		test.info("test completed");



		// calling flush writes everything to the log file
		extent.flush();

	}

}
