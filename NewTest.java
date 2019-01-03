package Firsttestngpackage;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NewTest {
	public String baseurl = "http://www.google.com";
	public String driverpath = "C:\\Users\\u6012191\\eclipse\\chromedriver.exe";
	public WebDriver driver;
	public String actualtitle = null;
	public String expectedtitle = "Googlee";
	
	
	
	
  @Test
  public void ValidateBrowser() {
	driver = new ChromeDriver();
	driver.get(baseurl);
	actualtitle = driver.getTitle();
  }
	@Test
	public void ValidateTitle(){
	Assert.assertEquals(actualtitle, expectedtitle);	
	
  
  }
  @AfterTest
  public void terminateBrowser() {
	  
	  driver.close();
  
  }
}
  

