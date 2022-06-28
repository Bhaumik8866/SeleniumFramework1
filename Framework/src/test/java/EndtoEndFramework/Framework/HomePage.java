package EndtoEndFramework.Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.HembergerMenu;
import pageObjects.loginPage;
import resources.initializeDriver;

public class HomePage extends initializeDriver{
	public static Logger log=LogManager.getLogger(initializeDriver.class.getName());
	public WebDriver driver;
	loginPage lp;
	HembergerMenu hem;
	
	@Test(dataProvider = "getdata")
	public void basePageNavigation(String username, String password) throws IOException
	{
		driver=driverinit();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		lp=new loginPage(driver);
		lp.UserName().sendKeys(username); //returns driver.findelement....
		lp.password().sendKeys(password);
		lp.login().click();
		hem=new HembergerMenu(driver);
		hem.hembergerbutton().click();
		log.info("Hemberger button opened");
	}
	@Test
	public void dashboardpage() throws IOException {
		
		hem.dashboardNewPage().click();
		log.info("dashbaord grid opened in new page");
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		//row stands for how many types of data we are providing
		//columns stands for how many data we are providing
		//Both index starts with zero
		Object[][] data=new Object[1][2];
		data[0][0]="Bhaumik";
		data[0][1]="Password2";
//		data[1][0]="Demo";
//		data[1][1]="password";
		
		return data;
	}
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("in after Method");
		driver.close();
	}

}
