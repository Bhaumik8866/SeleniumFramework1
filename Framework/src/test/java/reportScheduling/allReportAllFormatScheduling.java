package reportScheduling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HembergerMenu;
import pageObjects.loginPage;
import pageObjects.reportSection;
import pageObjects.requestsection;
import pageObjects.schedulerWindow;
import resources.getReportOutputFormats;
import resources.getReportParam;
import resources.initializeDriver;
import resources.reportNames;

public class allReportAllFormatScheduling extends initializeDriver{
	
	public static WebDriver driver;
	loginPage lp;
	public static HembergerMenu hem;
	public static reportSection rp;
	reportNames reports;
	getReportOutputFormats reportformat;
	reportSection rs;
	getReportParam param;
	schedulerWindow sch;
	requestsection requestsection;
	
	@Test
	public void shceduleAllFormat() throws IOException, InterruptedException 
	{
		driver=driverinit();
		Actions act = new Actions(driver);
		driver.get(prop.getProperty("url"));
		lp=new loginPage(driver);
		lp.UserName().sendKeys(prop.getProperty("username"));
		lp.password().sendKeys(prop.getProperty("password"));
		lp.login().click();
		Thread.sleep(5000);
		hem=new HembergerMenu(driver);
		hem.hembergerbutton().click();
		hem.documentSection().click();
		hem.report().click();
		rp=new reportSection(driver);
		act.doubleClick(rp.templateFolder()).perform();
		reports=new reportNames();
		reportformat=new getReportOutputFormats(driver);
		rs=new reportSection(driver);
		rs.ownerFiltericon().click();
		rs.filtersearch().sendKeys("Bhaumik");
		Thread.sleep(2000);
		rs.filterokbutton().click();
		Thread.sleep(2000);
		ArrayList<String> reportname=reports.getdata(); //this brings all report name from report data sheet of excel
		Iterator<String> e=reportname.iterator();
		sch=new schedulerWindow(driver);
		param=new getReportParam(driver);
		String oldTab = driver.getWindowHandle();
		
		for(int i=0;i< reportname.size();i++)
		{
			
//			rs.reportName(reportname.get(i)).click();
			if(reportname.get(i).equalsIgnoreCase("Annotations"))
			{
			ArrayList<String> list= reportformat.getdata("Annotations");
			String[] arrayoutputformats=list.get(1).split(",");
			for(String format:arrayoutputformats)
			{
			act.doubleClick(rs.reportName(reportname.get(i))).perform();
			ArrayList<String> paramdata= param.getdata(reportname.get(i));
			sch.paramtab().click();
			rs.annotationreportperiod().click();
			rs.periodoption(paramdata.get(2)).click();
			Thread.sleep(2000);
			rs.annotationreportcoverpageimage().click();
			rs.coverpageoption(paramdata.get(3)).click();
			rs.annotationreportreporttitle().sendKeys(paramdata.get(4));
			sch.outputtab().click();
			sch.outputname().clear();
			sch.outputname().sendKeys(paramdata.get(1));
			sch.outputformat().click();
			Thread.sleep(1000);
			sch.selectoutputformatlist(format).click();
			sch.runbutton().click();
			Thread.sleep(5000);
			driver.switchTo().window(oldTab);
			}

			
			}
			else if(reportname.get(i).equalsIgnoreCase("Customers details"))
			{
				ArrayList<String> list= reportformat.getdata("Customers details");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.paramtab().click();
				rs.customerdetailscustomername().clear();
				rs.customerdetailscustomername().sendKeys(paramdata.get(2));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(5000);
				driver.switchTo().window(oldTab);
				}
				
			}else if(reportname.get(i).equalsIgnoreCase("Customers details With 2 Params"))
			{
				ArrayList<String> list= reportformat.getdata("Customers details With 2 Params");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.paramtab().click();
				rs.customerdetailscustomername().clear();
				rs.customerdetailscustomername().sendKeys(paramdata.get(2));
				rs.customerdetailscountry().clear();
				rs.customerdetailscountry().sendKeys(paramdata.get(3));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(5000);
				driver.switchTo().window(oldTab);
				}
			}else if(reportname.get(i).equalsIgnoreCase("Income Statement"))
			{
				ArrayList<String> list= reportformat.getdata("Income Statement");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(5000);
				driver.switchTo().window(oldTab);
				}
				
			}else if(reportname.get(i).equalsIgnoreCase("Invoice"))
			{
				ArrayList<String> list= reportformat.getdata("Invoice");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.paramtab().click();
				rs.invoicecustomernumber().clear();
				rs.invoicecustomernumber().sendKeys(paramdata.get(2));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(5000);
				driver.switchTo().window(oldTab);
				
				}
			}else if(reportname.get(i).equalsIgnoreCase("Order details"))
			{
				ArrayList<String> list= reportformat.getdata("Order details");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.paramtab().click();
				rs.orderdetailsordernumber().clear();
				rs.orderdetailsordernumber().sendKeys(paramdata.get(2));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(5000);
				driver.switchTo().window(oldTab);
				}
				
			}else if(reportname.get(i).equalsIgnoreCase("Orders Payment"))
			{
				ArrayList<String> list= reportformat.getdata("Orders Payment");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(5000);
				driver.switchTo().window(oldTab);
				}
				
			}else if(reportname.get(i).equalsIgnoreCase("Sales by Productline"))
			{
				ArrayList<String> list= reportformat.getdata("Sales by Productline");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(5000);
				driver.switchTo().window(oldTab);
				}
			}
			else if(reportname.get(i).equalsIgnoreCase("Sales by Year"))
			{
				ArrayList<String> list= reportformat.getdata("Sales by Year");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(10000);
				driver.switchTo().window(oldTab);
				}
			}
			else if(reportname.get(i).equalsIgnoreCase("Top 5 Customers"))
			{
				ArrayList<String> list= reportformat.getdata("Top 5 Customers");
				String[] arrayoutputformats=list.get(1).split(",");
				for(String format:arrayoutputformats)
				{
				act.doubleClick(rs.reportName(reportname.get(i))).perform();
				ArrayList<String> paramdata= param.getdata(reportname.get(i));
				sch.outputtab().click();
				sch.outputname().clear();
				sch.outputname().sendKeys(paramdata.get(1));
				sch.outputformat().click();
				Thread.sleep(1000);
				sch.selectoutputformatlist(format).click();
				sch.runbutton().click();
				Thread.sleep(5000);
				driver.switchTo().window(oldTab);
				}
			}
			
			
		}
		//write here
		hem.hembergerbutton().click();
		Thread.sleep(2000);
		requestsection = new requestsection(driver);
		hem.requestsection().click();
		hem.request().click();
		Thread.sleep(3000);
//		requestsection.deleteallscheduledreports(driver);
		for(int i=0;i< reportname.size();i++)
		{
			ArrayList<String> paramdata= param.getdata(reportname.get(i));
			requestsection.completedreportname(paramdata.get(1)).click();
			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(@class,'ptitle')]")).isDisplayed());
			driver.findElement(By.xpath("//div[contains(@class,'rq_right_top')]//input[contains(@class,'checkselectall')]/parent::div//span[1]")).click();
			requestsection.completeddeletebutton().click();
			requestsection.deleteacceptbutton().click();
			Thread.sleep(2000);
			Assert.assertEquals(requestsection.deleteconfirmation().getText(), "Request deleted successfully");
		
		}
		
	}

}
