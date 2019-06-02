package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

	static WebDriver driver=null;

	@BeforeTest
	public void setUp(){
		WebDriverManager.chromedriver().version("2.4").setup();
		driver = new ChromeDriver();

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
		driver.close();
		driver.quit();
	}
}