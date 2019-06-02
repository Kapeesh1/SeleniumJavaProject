package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	static WebDriver driver=null;
	static WebElement element;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String projectPath= System.getProperty("user.dir");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);

		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/IEDriver/IEDriverServer.exe");

		driver= new InternetExplorerDriver(caps);
		driver.get("https://google.com");
		element=driver.findElement(By.name("q"));
		element.sendKeys("Automation step by step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();

	}

}
