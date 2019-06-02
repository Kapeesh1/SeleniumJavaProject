package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport_TestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver=null;

	@BeforeSuite
	public void setUp(){

		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		WebDriverManager.chromedriver().version("2.4").setup();
		driver = new ChromeDriver();
	}

	@Test
	public void test() throws IOException{

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");       
		driver.get("https://google.com");
		test.pass("Navigated to google page");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)"); 

		// info(details)
		test.info("This step shows usage of info(details)");  

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());  

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");  
	}
	@Test
	public void test2() throws IOException{

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");   

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)"); 

		// info(details)
		test.info("This step shows usage of info(details)"); 

		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());  

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");  
	}
	public void tearDownTest(){
		driver.close();
		driver.quit();
	}

	@AfterSuite
	public void tearDown(){

		extent.flush();
	}
}
