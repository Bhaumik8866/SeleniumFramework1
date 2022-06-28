package reportScheduling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.codegen.model.Action;
import pageObjects.HembergerMenu;
import pageObjects.loginPage;
import pageObjects.reportSection;
import pageObjects.requestsection;
import pageObjects.schedulerWindow;
import resources.initializeDriver;

public class HyperLinkDrillTest extends initializeDriver{
	
	public WebDriver driver;
	Properties prop;
	loginPage loginpage;
	HembergerMenu hemburger;
	reportSection reportsection;
	schedulerWindow scheduler;
	requestsection requestsection;
	String reportname="Automation_Hyperlink_Drill_Test";
	@Test
	public void hyperlinkdrill() throws IOException, InterruptedException
	{
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		driver=driverinit();
		driver.get(prop.getProperty("url"));
		String oldwindow=driver.getWindowHandle();
		loginpage=new loginPage(driver);
		loginpage.UserName().sendKeys(prop.getProperty("username"));
		loginpage.password().sendKeys(prop.getProperty("password"));
		loginpage.login().click();
		Thread.sleep(2000);
		hemburger=new HembergerMenu(driver);
		hemburger.hembergerbutton().click();
		Thread.sleep(2000);
		hemburger.documentSection().click();
		hemburger.report().click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		reportsection=new reportSection(driver);
		act.doubleClick(reportsection.templateFolder()).perform();
		reportsection.ownerFiltericon().click();
		reportsection.filtersearch().sendKeys("Bhaumik");
		Thread.sleep(2000);
		reportsection.filterokbutton().click();
		Thread.sleep(2000);
		act.doubleClick(driver.findElement(By.xpath("//div[text()=' HyperLink ']"))).perform();
		Thread.sleep(2000);
		scheduler=new schedulerWindow(driver);
		scheduler.paramtab().click();
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='No Parameter Found']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//h4[text()='No Parameter Found']")).getText(), "No Parameter Found");
		scheduler.outputtab().click();
		scheduler.outputname().clear();
		scheduler.outputname().sendKeys(reportname);
		scheduler.runbutton().click();
		Thread.sleep(2000);
		driver.switchTo().window(oldwindow);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		
		while(itr.hasNext())
		{
			itr.next();
//			System.out.println(itr.next());
			Thread.sleep(2000);
			driver.switchTo().window(itr.next());
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='aiv_hrep_rec_dtl']/p")).isDisplayed());
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"aiv_hrep_rec_dtl\"]/p")).getText(), "Showing 1 of 75");
			driver.findElement(By.xpath("//div[text()='1579']/parent::td/parent::tr//td//div//a[text()='Trucks and Buses']")).click();
			Thread.sleep(5000);
//			String drillwindow=driver.getWindowHandle();
//			driver.switchTo().window(oldwindow);
//			driver.switchTo().window(drillwindow);
			driver.switchTo().window(oldwindow);
			Set<String> handles1=driver.getWindowHandles();
			Iterator<String> itr1=handles1.iterator();
			while(itr1.hasNext())
			{
			itr1.next();
			itr1.next();
//			System.out.println(itr.next());
			Thread.sleep(2000);
			driver.switchTo().window(itr1.next());
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='aiv_hrep_rec_dtl']/p")).isDisplayed());
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"aiv_hrep_rec_dtl\"]/p")).getText(), "Showing 1 of 1");
			System.out.println(driver.findElement(By.xpath("//div[contains(@id,'AUTOGENBOOKMARK')]")).getText());
			List<WebElement> data=driver.findElements(By.xpath("//td[@style=' overflow:hidden;']/div"));
			for(WebElement data1:data)
			{
//				System.out.println("Here");
				System.out.println(data1.getText());
			}
			}
		}
		driver.switchTo().window(oldwindow);
		hemburger.hembergerbutton().click();
	    Thread.sleep(2000);
	    hemburger.requestsection().click();
	    Thread.sleep(2000);
	    hemburger.request().click();
	    Thread.sleep(2000);
	    requestsection=new requestsection(driver);
	    
	    requestsection.completedtab().click();
	    requestsection.refreshicon().click();
	    Thread.sleep(2000);
	    requestsection.completedreportname(reportname).click();
	    String completedreportname=requestsection.completedreporttitle().getText();
	    Assert.assertEquals(completedreportname, reportname);
	    driver.findElement(By.xpath("//div[contains(@class,'rq_right_top')]//input[contains(@class,'checkselectall')]/parent::div//span[1]")).click();
		requestsection.completeddeletebutton().click();
		requestsection.deleteacceptbutton().click();
		Thread.sleep(2000);
		Assert.assertEquals(requestsection.deleteconfirmation().getText(), "Request deleted successfully");
	    
		driver.quit();
		
	}
}
