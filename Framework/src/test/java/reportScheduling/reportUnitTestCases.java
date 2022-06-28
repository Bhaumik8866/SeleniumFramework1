package reportScheduling;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import pageObjects.reportSection;
import resources.initializeDriver;

public class reportUnitTestCases extends initializeDriver{
	
	public static WebDriver driver;
	public static loginPage lp;
	public static reportSection rs;
	public static Actions act;
	Random random = new Random();
	int foldername=random.nextInt(1000);
	@BeforeTest
	public void loginToApplication() throws IOException, InterruptedException
	{
		driver=driverinit();
		driver.get(prop.getProperty("url"));
		lp=new loginPage(driver);
		lp.UserName().sendKeys(prop.getProperty("username"));
		lp.password().sendKeys(prop.getProperty("password"));
		lp.login().click();
		Thread.sleep(5000);
		
	}
	
	@Test
	public void createFolderFooter() throws IOException, InterruptedException
	{
		rs=new reportSection(driver);
		rs.createfolderfooter().click();
	}
	
	@Test
	(dependsOnMethods={"createFolderFooter"})
	public void createFolderWindow() throws InterruptedException, IOException
	{	
//		rs=new reportSection(driver);
		Assert.assertEquals(rs.createfolderwindow().getText(), "Create Folder");
		System.out.println(rs.createfolderwindow().getText()); 
		boolean disabled=rs.createfoldercreatebutton().isEnabled();
		Assert.assertFalse(disabled);
		rs.createfoldercreatebutton().click();
		Assert.assertTrue(rs.nonamevalidation().isDisplayed());
		rs.createfoldertext().sendKeys("Automation_Test"+" "+foldername);
		Assert.assertTrue(rs.createfolderbuttonenabled().isEnabled());
		rs.createfolderbuttonenabled().click();
		Assert.assertEquals(rs.foldersuccessmessage().getText(), "Folder created Successfully");
		rs.folderselect("Automation_Test"+" "+foldername).click();
//		rs.deletefolder("Automation_Test"+" "+foldername);
		
	}
	
	@AfterTest
	public void closeBrowserWindow() throws InterruptedException
	{
		rs.deletefolder("Automation_Test"+" "+foldername);
		driver.close();
	}

}
