package reportScheduling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HembergerMenu;
import pageObjects.dashboardGrid;
import pageObjects.dashboardeditmode;
import pageObjects.loginPage;
import pageObjects.reportwidget;
import resources.initializeDriver;

public class dashboardReportWidgetTest extends initializeDriver{
	
	public static WebDriver driver;
	loginPage login;
	Properties prop;
	HembergerMenu hem;
	dashboardGrid dgrid;
	dashboardeditmode dedit;
	reportwidget reportwidget;
	@Test
	public void reportwidgettest() throws IOException, InterruptedException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		driver=driverinit();
		login= new loginPage(driver);
		driver.get(prop.getProperty("url"));
		login.UserName().sendKeys(prop.getProperty("username"));
		login.password().sendKeys(prop.getProperty("password"));
		login.login().click();
		Thread.sleep(2000);
		hem=new HembergerMenu(driver);
		hem.hembergerbutton().click();
		Thread.sleep(2000);
		hem.dashboardgridicon().click();
		Thread.sleep(2000);
		dgrid=new dashboardGrid(driver);
		Actions act=new Actions(driver);
		act.doubleClick(dgrid.automationtestfolder()).perform();
		Thread.sleep(2000);
		act.doubleClick(dgrid.reportwidgetfolder()).perform();
		Thread.sleep(2000);
		dgrid.createdashboardfooter().click();
		dgrid.createdashboardname().sendKeys("Autmation_Report_Widget_Test");
		dgrid.createdashboardbutton().click();
		Thread.sleep(5000);
		dedit=new dashboardeditmode(driver);
		dedit.reportwidgeticon().click();
		Thread.sleep(3000);
		reportwidget=new reportwidget(driver);
		reportwidget.selecttemplatefolder().click();
		reportwidget.charlength255report().click();
		Thread.sleep(2000);
		reportwidget.reportoutputtype().click();
		reportwidget.reporttypehtml().click();
		reportwidget.previewbutton().click();
		Thread.sleep(5000);
		reportwidget.saveandexitbutton().click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//div[text()='Report Widget 1']"))).perform();
		act.clickAndHold(driver.findElement(By.xpath("//div[contains(@class,'gridster-item-resizable-handler')][5]"))).perform();
		Thread.sleep(5000);
		act.moveByOffset(500, 300).perform();
		act.release(driver.findElement(By.xpath("//div[contains(@class,'gridster-item-resizable-handler')][5]"))).perform();
		
		dedit.dashboardpreviewbutton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Save And Exit']")).click();
		
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='AIV TimeTrackingggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg']")).isDisplayed());
		
	}
	
	@AfterTest
	public void deletedashboard() throws InterruptedException
	{
		hem.hembergerbutton().click();
		Thread.sleep(2000);
		hem.dashboardgridicon().click();
		Thread.sleep(2000);
		dgrid=new dashboardGrid(driver);
		Actions act=new Actions(driver);
		act.doubleClick(dgrid.automationtestfolder()).perform();
		Thread.sleep(2000);
		act.doubleClick(dgrid.reportwidgetfolder()).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=' Autmation_Report_Widget_Test ']")).click();
		dgrid.deletedashboardfooter().click();
		Thread.sleep(2000);
		dgrid.deletedialogboxallversioncheckbox().click();
		dgrid.deletedialogboxdelete().click();
		//Delete successfully
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Delete successfully']")).getText(), "Delete successfully");
		driver.close();
	}

}
