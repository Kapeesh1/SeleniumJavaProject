package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pom_pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {

	private static WebDriver driver=null;
	public static void main(String[] args) {
		googleSearchTest();
	}

	public static void googleSearchTest(){
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriverManager.chromedriver().version("2.4").setup();
		driver = new ChromeDriver();

		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);

		driver.get("https://google.com");
		searchPageObj.setTextInSearchBox("facebook");
		searchPageObj.clickSearchButton();
	}
}