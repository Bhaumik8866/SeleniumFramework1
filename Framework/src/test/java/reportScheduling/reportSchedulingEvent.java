package reportScheduling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

public class reportSchedulingEvent extends initializeDriver{
	

	public WebDriver driver;
	loginPage login;
	HembergerMenu hemburger;
	reportSection reportsection;
	public Properties eventprop;
	schedulerWindow scheduler;
	scheduleDateTime scheduledate;
	requestsection requestsection;
	
	@Test
	public void eventscheduling() throws IOException, InterruptedException
	{
		eventprop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\reportscheduling_event.properties");
		eventprop.load(fis);
		driver= driverinit();
		Actions act = new Actions(driver);
		driver.get(prop.getProperty("url"));
		login=new loginPage(driver);
		login.UserName().sendKeys(eventprop.getProperty("username"));
		login.password().sendKeys(eventprop.getProperty("password"));
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
		act.doubleClick(reportsection.reportName(eventprop.getProperty("eventreport"))).perform();
		scheduler=new schedulerWindow(driver);
		scheduler.paramtab().click();
		reportsection.customerdetailscustomername().clear();
		reportsection.customerdetailscustomername().sendKeys(eventprop.getProperty("parameter"));
		scheduler.scheduletab().click();
		scheduler.scheduletypedropdown().click();
		scheduler.scheduletypeevent().click();
		Assert.assertEquals(scheduler.eventdropdown().getText(),"Create/Manage Events");
		scheduler.eventcreatebutton().click();
		Thread.sleep(1000);
		int eventnumber=(int)(Math.random()*(600-500+1)+500);
		scheduler.eventnumber().sendKeys(String.valueOf(eventnumber));
		scheduler.eventtype().sendKeys("Automation_test"+" "+String.valueOf(eventnumber));
		scheduler.eventdescription().sendKeys("Automation_test"+" "+String.valueOf(eventnumber));
		scheduler.eventsubmitbutton().click();
		scheduler.eventdropdown().click();
		scheduler.selecteventoption(eventnumber+"."+" "+"Automation_test"+" "+String.valueOf(eventnumber)).click();
		scheduler.outputtab().click();
		scheduler.outputname().clear();
		scheduler.outputname().sendKeys(eventprop.getProperty("eventreportoutputname"));
		scheduler.runbutton().click();
		Thread.sleep(2000);
		Assert.assertEquals(reportsection.eventsuccessmessage().getText(), "Event updated");
		hemburger.hembergerbutton().click();
		Thread.sleep(2000);
		hemburger.requestsection().click();
		hemburger.request().click();
		Thread.sleep(2000);
		requestsection =new requestsection(driver);
		requestsection.waitingforeventtab().click();
		requestsection.eventwaitingreportname(eventprop.getProperty("eventreportoutputname")).click();
		Assert.assertEquals(requestsection.waitingforeventreporttitle().getText(), eventprop.getProperty("eventreportoutputname"));
		Assert.assertEquals(requestsection.waitingforeventstatus().getText(), "Waiting For Events");
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
		act.doubleClick(reportsection.reportName(eventprop.getProperty("triggerreportname"))).perform();
		scheduler=new schedulerWindow(driver);
		scheduler.paramtab().click();
		scheduler.scheduletab().click();
		scheduler.schedulefrequency("Once").click();
		scheduledate=new scheduleDateTime();
	    scheduler.oncedatetimepicker().sendKeys(scheduledate.scheduledatetime(0, 0, 0, 0, 1, 0));
	    scheduler.outputtab().click();
	    scheduler.outputname().clear();
	    scheduler.outputname().sendKeys(eventprop.getProperty("triggerreportoutputname"));
	    scheduler.eventonsuccesslist().click();
	    scheduler.successeventid(String.valueOf(eventnumber)).click();
	    scheduler.eventonfaillist().click();
	    scheduler.faileventoption().click();
	    scheduler.runbutton().click();
	    Thread.sleep(3000);
	    hemburger.hembergerbutton().click();
	    Thread.sleep(2000);
	    hemburger.requestsection().click();
	    Thread.sleep(2000);
	    hemburger.request().click();
	    Thread.sleep(2000);
	    requestsection.scheduletab().click();
	    Thread.sleep(2000);
	    requestsection.scheduletabreport(eventprop.getProperty("triggerreportoutputname")).click();
	    Thread.sleep(2000);
	    String reporttitle=requestsection.schedulereporttitle().getText();
	    Assert.assertEquals(reporttitle, eventprop.getProperty("triggerreportoutputname"));
	    String schedulestatus=requestsection.schedulestatus().getText();
	    Assert.assertEquals(schedulestatus, "Scheduled");
	    Thread.sleep(80000);
	    requestsection.completedtab().click();
	    requestsection.refreshicon().click();
	    Thread.sleep(2000);
	    requestsection.completedreportname(eventprop.getProperty("triggerreportoutputname")).click();
	    String completedreportname=requestsection.completedreporttitle().getText();
	    Assert.assertEquals(completedreportname, eventprop.getProperty("triggerreportoutputname"));
	    String completedstatus=requestsection.completedstatus().getText();
	    Assert.assertEquals(completedstatus, "Completed");
	    requestsection.completedstatus().click();
	    requestsection.completeddeletebutton().click();
	    Thread.sleep(2000);
	    requestsection.deleteacceptbutton().click();
	    Thread.sleep(1000);
	    String deleteconfirm=requestsection.deleteconfirmation().getText();
	    Assert.assertEquals(deleteconfirm, "Request deleted successfully");
		Thread.sleep(5000);
		
		requestsection.refreshicon().click();
	    Thread.sleep(2000);
	    requestsection.completedreportname(eventprop.getProperty("eventreportoutputname")).click();
	    String completedreportname2=requestsection.completedreporttitle().getText();
	    Assert.assertEquals(completedreportname2, eventprop.getProperty("eventreportoutputname"));
	    String completedstatus2=requestsection.completedstatus().getText();
	    Assert.assertEquals(completedstatus2, "Completed");
	    requestsection.completedstatus().click();
	    requestsection.completeddeletebutton().click();
	    Thread.sleep(2000);
	    requestsection.deleteacceptbutton().click();
	    Thread.sleep(1000);
	    String deleteconfirm2=requestsection.deleteconfirmation().getText();
	    Assert.assertEquals(deleteconfirm2, "Request deleted successfully");
	    hemburger.hembergerbutton().click();
	    hemburger.documentSection().click();
	    hemburger.report().click();
	    act.doubleClick(reportsection.templateFolder()).perform();
		reportsection.ownerFiltericon().click();
		reportsection.filtersearch().sendKeys("Bhaumik");
		Thread.sleep(2000);
		reportsection.filterokbutton().click();
		act.doubleClick(reportsection.reportName(eventprop.getProperty("eventreport"))).perform();
		scheduler.paramtab().click();
		reportsection.customerdetailscustomername().clear();
		reportsection.customerdetailscustomername().sendKeys(eventprop.getProperty("parameter"));
		scheduler.scheduletab().click();
		scheduler.scheduletypedropdown().click();
		scheduler.scheduletypeevent().click();
		Assert.assertEquals(scheduler.eventdropdown().getText(),"Create/Manage Events");
		scheduler.eventdropdown().click();
		scheduler.selecteventoption(eventnumber+"."+" "+"Automation_test"+" "+String.valueOf(eventnumber)).click();
		scheduler.eventdeleteicon().click();
		Assert.assertEquals(scheduler.eventdeletemessage().getText(), "Delete successfully");
	    driver.close();
		
		
	}

}
