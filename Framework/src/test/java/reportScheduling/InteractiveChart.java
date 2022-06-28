package reportScheduling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import pageObjects.HembergerMenu;
import pageObjects.loginPage;
import pageObjects.reportSection;
import pageObjects.requestsection;
import pageObjects.schedulerWindow;
import resources.initializeDriver;

public class InteractiveChart extends initializeDriver{

	public WebDriver driver;
	Properties prop;
	loginPage loginpage;
	HembergerMenu hemburger;
	reportSection reportsection;
	schedulerWindow scheduler;
	requestsection requestsection;
	String reportname="Automation_InteractiveChart_Test";
	
	@Test
	public void interactivechartdrilltest() throws InterruptedException, IOException
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
		act.doubleClick(driver.findElement(By.xpath("//div[text()=' InteractiveChart ']"))).perform();
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
			Thread.sleep(2000);
			driver.switchTo().window(itr.next());
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='aiv_hrep_rec_dtl']/p")).isDisplayed());
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"aiv_hrep_rec_dtl\"]/p")).getText(), "Showing 1 of 1");
			driver.findElement(By.xpath("//area[@title='Classic Metal Creations']")).click();
			Thread.sleep(5000);
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
			List<WebElement> headers= driver.findElements(By.xpath("//table[@id='__bookmark_1']//tbody/tr[2]"));
			System.out.println(driver.findElements(By.xpath("//table[@id='__bookmark_1']//tbody/tr")));
			Iterator<WebElement> table=headers.iterator();
//			for(WebElement data1:headers)
//			{
//				System.out.println("elements "+data1);
//				List<WebElement> data2=data1.findElements(By.xpath("//th//div"));
//				for(WebElement data3:data2)
//				{
//					System.out.println(data3.getText());
//				}
//			}
			while(table.hasNext())
			{
//				System.out.println("elements "+table.next());
				List<WebElement> data2=table.next().findElements(By.xpath("//th//div"));
				for(WebElement data3:data2)
					{
						System.out.println(data3.getText());
					}
			}
			
			
			}
			
		}
		
//		driver.quit();
			
		}
	
}
