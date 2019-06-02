package test;

import log4j.Log4jDemo;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import config.PropertiesFile_Demo;

public class TestNG_Demo {

	static WebDriver driver=null;
	public static String browserName= null;
	Logger logger = LogManager.getLogger(Log4jDemo.class);

	@BeforeTest
	public void setUp(){
		String projectPath= System.getProperty("user.dir");
		PropertiesFile_Demo.getProperties();
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().version("2.4").setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		    logger.info("Browser Started");
		}
	}
	@Test
	public static void googleSearch(){

		//goto google.com
		driver.get("https://google.com/");

		//search textbox
		WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("facebook.com");
		wb.submit();

	}

	@AfterTest
	public void TearDown(){
		PropertiesFile_Demo.setProperties();
		driver.close();
		//driver.quit();
	}
}