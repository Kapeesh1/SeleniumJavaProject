import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserTest {

	public static void main(String[] args) {

		//String projectPath= System.getProperty("user.dir");
		//System.out.println("projectPath");

		//System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://makemytrip.com");


		WebDriverManager.chromedriver().version("2.4").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://makemytrip.com/");

		//WebElement textBox= driver.findElement(By.id("email")); //input[@id='username']

		WebElement textBox=driver.findElement(By.id("SW")).findElement(By.xpath("//p[contains(text(),'Login or Create Account')]"));

		textBox.click();

		textBox=driver.findElement(By.id("username"));
		textBox.sendKeys("kapeesh1@gmail.com");

		textBox= driver.findElement(By.id("password"));
		textBox.sendKeys("9412176701");
		
		textBox= driver.findElement(By.xpath("//button[@class='capText font16']")).findElement(By.name("LOGIN"));
		textBox.click();

		//driver.close(); 
	}

}

