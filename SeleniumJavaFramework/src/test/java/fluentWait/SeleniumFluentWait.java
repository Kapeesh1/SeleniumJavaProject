package fluentWait;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumFluentWait {

	public static void main(String[] args){
		test();
	}

	public static void test(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/Testing/SeleniumJavaFramework/drivers/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---headless");

		WebDriver driver= new ChromeDriver(options);

		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Abcd");;
		WebElement element = driver.findElement(By.name("btnK"));
		element.submit();
	}
}
