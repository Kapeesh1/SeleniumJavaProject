package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom_pages.GoogleSearchPage;

public class GoogleSearch_test {

	private static WebDriver driver=null;
	public static void main(String[] args) {
		googleSearch();
	}


	public static void googleSearch(){
		WebDriverManager.chromedriver().version("2.4").setup();
		driver = new ChromeDriver();

		//goto google.com
		driver.get("https://google.com/");

		//search textbox
		/*WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("facebook.com");
		wb.submit();*/
		GoogleSearchPage.textBox_search(driver).sendKeys("facebook");
		GoogleSearchPage.button_search(driver);
		
	}
}