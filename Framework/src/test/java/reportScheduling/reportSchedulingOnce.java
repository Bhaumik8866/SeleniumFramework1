package reportScheduling;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HembergerMenu;
import pageObjects.loginPage;
import pageObjects.reportSection;
import pageObjects.requestsection;
import pageObjects.schedulerWindow;
import resources.initializeDriver;
import resources.scheduleDateTime;

public class reportSchedulingOnce extends initializeDriver{
	
	public WebDriver driver;
	loginPage login;
	HembergerMenu hemburger;
	reportSection reportsection;
	public Properties onceprop;
	schedulerWindow scheduler;
	scheduleDateTime scheduledate;
	requestsection requestsection;
	
	
	@Test
	public void scheduleonce() throws IOException, InterruptedException
	{
		onceprop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\reportscheduling_once.properties");
		onceprop.load(fis);
		driver= driverinit();
		Actions act = new Actions(driver);
		driver.get(prop.getProperty("url"));
		login=new loginPage(driver);
		login.UserName().sendKeys(onceprop.getProperty("username"));
		login.password().sendKeys(onceprop.getProperty("password"));
		login.login().click();
		Thread.sleep(5000);
		hemburger=new HembergerMenu(driver);
		hemburger.hembergerbutton().click();
		Thread.sleep(2000);
		hemburger.documentSection().click();
		hemburger.report().click();
		Thread.sleep(5000);
		reportsection=new reportSection(driver);
		act.doubleClick(reportsection.templateFolder()).perform();
		reportsection.ownerFiltericon().click();
		reportsection.filtersearch().sendKeys("Bhaumik");
		Thread.sleep(2000);
		reportsection.filterokbutton().click();
		act.doubleClick(reportsection.reportName(onceprop.getProperty("reportname"))).perform();
		scheduler=new schedulerWindow(driver);
		scheduler.paramtab().click();
		reportsection.customerdetailscustomername().clear();
		reportsection.customerdetailscustomername().sendKeys(onceprop.getProperty("parameter"));
		scheduler.scheduletab().click();
		scheduler.schedulefrequency("Once").click();
		scheduledate=new scheduleDateTime();
	    scheduler.oncedatetimepicker().sendKeys(scheduledate.scheduledatetime(0, 0, 0, 0, 2, 0));
	    scheduler.outputtab().click();
	    scheduler.outputname().clear();
	    scheduler.outputname().sendKeys(onceprop.getProperty("reportoutputname"));
	    scheduler.outputformat().click();
	    Thread.sleep(2000);
	    scheduler.selectoutputformatlist(onceprop.getProperty("reportoutputformat")).click();
	    scheduler.runbutton().click();
	    Thread.sleep(3000);
	    hemburger.hembergerbutton().click();
	    Thread.sleep(2000);
	    hemburger.requestsection().click();
	    Thread.sleep(2000);
	    hemburger.request().click();
	    Thread.sleep(2000);
	    requestsection=new requestsection(driver);
	    requestsection.scheduletab().click();
	    Thread.sleep(2000);
	    requestsection.scheduletabreport(onceprop.getProperty("reportoutputname")).click();
	    Thread.sleep(2000);
	    String reporttitle=requestsection.schedulereporttitle().getText();
	    Assert.assertEquals(reporttitle, onceprop.getProperty("reportoutputname"));
	    String schedulestatus=requestsection.schedulestatus().getText();
	    Assert.assertEquals(schedulestatus, "Scheduled");
	    Thread.sleep(150000);
	    requestsection.completedtab().click();
	    requestsection.refreshicon().click();
	    Thread.sleep(2000);
	    requestsection.completedreportname(onceprop.getProperty("reportoutputname")).click();
	    String completedreportname=requestsection.completedreporttitle().getText();
	    Assert.assertEquals(completedreportname, onceprop.getProperty("reportoutputname"));
	    String completedstatus=requestsection.completedstatus().getText();
	    Assert.assertEquals(completedstatus, "Completed");
	    requestsection.completedstatus().click();
	    requestsection.completeddeletebutton().click();
	    Thread.sleep(2000);
	    requestsection.deleteacceptbutton().click();
	    Thread.sleep(1000);
	    String deleteconfirm=requestsection.deleteconfirmation().getText();
	    Assert.assertEquals(deleteconfirm, "Request deleted successfully");
	    
	    
	    
	}

}
