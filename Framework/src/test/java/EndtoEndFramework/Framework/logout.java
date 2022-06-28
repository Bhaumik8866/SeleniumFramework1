package EndtoEndFramework.Framework;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HembergerMenu;
import pageObjects.loginPage;
import resources.initializeDriver;

public class logout extends initializeDriver{
	
	@Test
	public void controlPanelSection() throws IOException
	{
		driver=driverinit();
		driver.get(prop.getProperty("url"));
		loginPage lp=new loginPage(driver);
		lp.UserName().sendKeys(prop.getProperty("username"));
		lp.password().sendKeys(prop.getProperty("password"));
		lp.login().click();
		HembergerMenu hem=new HembergerMenu(driver);
		hem.hembergerbutton().click();
		hem.logout().click();
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
