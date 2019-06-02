package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_googleSearch {

	public static void main(String[] args) {
		googleSearch();
	}


	public static void googleSearch(){
		WebDriverManager.chromedriver().version("2.4").setup();
		WebDriver driver = new ChromeDriver();

		//goto google.com
		driver.get("https://google.com/");

		//search textbox
		WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("facebook.com");
		wb.submit();

	}
}