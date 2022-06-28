package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

public class requestsection {

	WebDriver driver;
	
	private By scheduletab=By.xpath("//span[text()='Schedule']");
	private By schedulereporttitle=By.xpath("//p[contains(@class,'ptitle')]");
	private By schedulestatus=By.xpath("//div[contains(@class,'rqst_content')]");
	private By completedtab=By.xpath("//span[text()='Completed']");
	private By completedreporttitle=By.xpath("//p[contains(@class,'ptitle')]");
	private By completedstatus=By.xpath("//div[text()='Completed']");
	private By completeddeletebutton=By.xpath("//span[text()='Delete']");
	private By deleteacceptbutton=By.xpath("//span[@translate='common_accept']");
	private By deleteconfirmation=By.xpath("//*[text()='Request deleted successfully']");
	private By refreshicon=By.xpath("//i[contains(@class,'fa-arrows-rotate')]");
	private By getallscheduledreportleft=By.xpath("//tr[@role='row']");
	private By waitingforeventtab=By.xpath("//span[text()='Waiting For Event']");
	private By waitingforeventreporttitle=By.xpath("//p[contains(@class,'ptitle')]");
	private By waitingforeventstatus=By.xpath("//div[text()='Waiting For Events']");
	
	
	public requestsection(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}



	public WebElement scheduletab()
	{
		return driver.findElement(scheduletab);
	}
	
	//td[text()='Automation_report_scheduling_once']
	
	public WebElement scheduletabreport(String reportoutputname)
	{
		return driver.findElement(By.xpath("//td[text()='"+reportoutputname+"']"));
	}
	
	public WebElement schedulereporttitle()
	{
		return driver.findElement(schedulereporttitle);
	}
	
	public WebElement schedulestatus()
	{
		return driver.findElement(schedulestatus);
	}
	public WebElement completedtab()
	{
		return driver.findElement(completedtab);
	}
	//td[@aria-label='Customers detailsAutomation_report_scheduling_once column header Report Name']
	public WebElement completedreportname(String reportname)
	{
		return driver.findElement(By.xpath("//td[text()='"+reportname+"']"));
	}
	public WebElement completedreporttitle()
	{
		return driver.findElement(completedreporttitle);
	}
	
	public WebElement completedstatus()
	{
		return driver.findElement(completedstatus);
	}
	public WebElement completeddeletebutton()
	{
		return driver.findElement(completeddeletebutton);
	}
	public WebElement deleteacceptbutton()
	{
		return driver.findElement(deleteacceptbutton);
	}
	
	//Request deleted successfully
	
	public WebElement deleteconfirmation()
	{
		return driver.findElement(deleteconfirmation);
	}
	public WebElement refreshicon()
	{
		return driver.findElement(refreshicon);
	}
	
	public List<WebElement> getallscheduledreportleft()
	{
		return driver.findElements(getallscheduledreportleft);
	}
	
	public WebElement waitingforeventtab()
	{
		return driver.findElement(waitingforeventtab);
	}
	
	//td[text()='Customers details']
	
	public WebElement eventwaitingreportname(String reportname)
	{
		return driver.findElement(By.xpath("//td[text()='"+reportname+"']"));
	}
	public WebElement waitingforeventreporttitle()
	{
		return driver.findElement(waitingforeventreporttitle);
	}
	
	
	public WebElement waitingforeventstatus()
	{
		return driver.findElement(waitingforeventstatus);
	}
	
//	public void deleteallscheduledreports(WebDriver driver2) throws InterruptedException
//	{
//		this.driver=driver2;
//		List<WebElement> reports=getallscheduledreportleft();
//		Iterator<WebElement> itr=reports.iterator();
//		
//			itr.next().click();
//			Thread.sleep(2000);
//			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(@class,'ptitle')]")).isDisplayed());
//			driver.findElement(By.xpath("//div[contains(@class,'rq_right_top')]//input[contains(@class,'checkselectall')]/parent::div//span[1]")).click();
//			requestsection reqs=new requestsection(driver);
//			reqs.completeddeletebutton().click();
//			reqs.deleteacceptbutton().click();
//			Thread.sleep(2000);
//			Assert.assertEquals(reqs.deleteconfirmation().getText(), "Request deleted successfully");
//			
//		
//	}
}
