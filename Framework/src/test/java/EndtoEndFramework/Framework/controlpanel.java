package EndtoEndFramework.Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HembergerMenu;
import pageObjects.loginPage;
import resources.initializeDriver;

public class controlpanel extends initializeDriver{
	public static Logger log=LogManager.getLogger(initializeDriver.class.getName());
	public WebDriver driver;
	@Test
	public void controlPanelSection() throws IOException
	{
		
		driver=driverinit();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		loginPage lp=new loginPage(driver);
		lp.UserName().sendKeys(prop.getProperty("username"));
		lp.password().sendKeys(prop.getProperty("password"));
		lp.login().click();
		HembergerMenu hem=new HembergerMenu(driver);
		hem.hembergerbutton().click();
		log.info("Hemberger button opened");
		hem.controlPanel().sendKeys(Keys.CONTROL,Keys.ENTER);
		log.info("controlpanel page opened");
		
	}
	@AfterTest	
	public void closeBrowser()
	{
		System.out.println("in after Method");
		driver.close();
	}
}
