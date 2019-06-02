package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile_Demo;

public class ExcelDataProvider {
	 WebDriver driver = null;
	
	@BeforeTest
	public void setUp(){
		String projectPath= System.getProperty("user.dir");
		PropertiesFile_Demo.getProperties();
			WebDriverManager.chromedriver().version("2.4").setup();
			driver = new ChromeDriver();
	}	
	
	
	
	@Test(dataProvider="test1data")
	public void test1(String UserName, String password){
		System.out.println(UserName+ " "+password);
		
		driver.get("https://linkedin.com/login?trk=guest_homepage-basic_nav-header-signin");
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(password);
		//elem.submit();
		
	}

	@DataProvider(name = "test1data")
	public Object[][] getData(){
		String excelPath = "C:/Users/Admin/Desktop/Testing/SeleniumJavaFramework/excel/data.xlsx";
		Object data[][]= testData(excelPath, "UserData");
		
		return data;
		
	}
	
	public  Object[][] testData(String excelPath, String sheetName){
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object data[][]= new Object [rowCount-1][colCount];
		for(int i=1;i<rowCount; i++){
			for(int j=0; j<colCount; j++){
				
				String cellData = excel.getCellDataString(i,j);
				System.out.print(cellData + "   ");
				data[i-1][j]=cellData;
			}
			System.out.println();
		}
		return data;
	}

}