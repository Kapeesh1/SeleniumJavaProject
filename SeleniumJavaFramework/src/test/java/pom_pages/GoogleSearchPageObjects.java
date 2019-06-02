package pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPageObjects {

	WebDriver driver = null;
	By textBox_search= By.name("q");
	By button_search = By.name("btnK");

	public GoogleSearchPageObjects(WebDriver driver){
		this.driver= driver;
	}
	public void setTextInSearchBox(String text){
		driver.findElement(textBox_search).sendKeys(text);
	}
	public void clickSearchButton(){
		WebElement elem= driver.findElement(button_search);
		elem.submit();
		
	}
}