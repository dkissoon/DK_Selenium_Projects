package Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class OpenURL {
public static void main(String[] args) throws InterruptedException, IOException
		    {
	Logger logger=Logger.getLogger("OpenURL");
	PropertyConfigurator.configure("log4j.Properties");
	Properties prop = new Properties();
	FileInputStream fileInput = null;
		            File file = new File("C:\\Users\\u6012191\\eclipse\\OR.Properties");
		            
		           try {
		            fileInput = new FileInputStream(file);
		           } catch (FileNotFoundException e) {
		                  e.printStackTrace();
		           }
		          
		 //load properties file
		           try {
		                  prop.load(fileInput);
		             	                  
		           } catch (IOException e) {
		                  e.printStackTrace();
		           }
		    
		           //sets chromedriver.exe
						System.setProperty("webdriver.chrome.driver", "C:\\Users\\u6012191\\eclipse\\chromedriver.exe");
				//sets driver object
						WebDriver _driver;
						_driver = new ChromeDriver();
					
						_driver.get(prop.getProperty("PROD.URL"));
				//set sleep for 5 seconds
						 Thread.sleep(5000);
						 logger.info("Prod URL Opened");
						 
						/* set browser size
						 Dimension d = new Dimension(200,600);
					     driver.manage().window().setSize(d);
					     */
						//set browser as maximize
						_driver.manage().window().maximize();
						
						//Login to LS2 PROD
						 Thread.sleep(5000);
						_driver.findElement(By.id(prop.getProperty("LoanStar.Login.UserName"))).sendKeys(prop.getProperty("Username"));
						_driver.findElement(By.id(prop.getProperty("LoanStar.Login.Password"))).sendKeys(prop.getProperty("Password"));
						_driver.findElement(By.id(prop.getProperty("LoanStar.Login.SignIn"))).click();
						 Thread.sleep(5000);
						 logger.info("Login Successful");
						 
						 //Launch Tax Provision Tile
						_driver.findElement(By.xpath(prop.getProperty("TaxProvisionTile"))).click();
						Thread.sleep(25000);
						logger.info("Tax Provision Tile Launch successful");
						 //Find Instance via Filter						 						
						_driver.findElement(By.xpath(prop.getProperty("PROD.Instance.Filter"))).click();
						Thread.sleep(5000);
						_driver.findElement(By.xpath(prop.getProperty("PROD.Instance.FilterSearch"))).sendKeys(prop.getProperty("PROD.InstanceName"));
						Thread.sleep(5000);
						_driver.findElement(By.xpath(prop.getProperty("PROD.Instance.FilterApply"))).click();
						Thread.sleep(5000);
						//Launch Filtered Instance
						_driver.findElement(By.xpath(prop.getProperty("InstanceName1"))).click();
						logger.info("Instance launched successful");
					
						
						//Open OIT Integration
						Thread.sleep(30000);
						_driver.findElement(By.xpath(prop.getProperty("MyDatasetsImport"))).click();
						Thread.sleep(5000);
						logger.info("OIT Worksheet Opened");
						
						_driver.findElement(By.xpath(prop.getProperty("MyDatasetsImportOIT"))).click();
						Thread.sleep(10000);
						//_driver.findElement(By.xpath(prop.getProperty("OITYear"))).click();
						//select1.selectByVisibleText("2012");
						_driver.findElement(By.xpath(prop.getProperty("OITRetrieve"))).click();
						_driver.findElement(By.xpath(prop.getProperty("OITPopulateIncome"))).click();
						Thread.sleep(10000);				
						logger.info("OIT Data Pull successful");
				         _driver.findElement(By.xpath(prop.getProperty("OITPopulateData"))).click();
				         Thread.sleep(10000);
				         logger.info("OIT Data submitted to Job");
				        _driver.findElement(By.xpath(prop.getProperty("PROD.OIT.CloseWindow"))).click();
				         Thread.sleep(5000);
				         _driver.findElement(By.xpath(prop.getProperty("PROD.Job"))).click();
				         //_driver.quit();
				         
				         
				
}
}


