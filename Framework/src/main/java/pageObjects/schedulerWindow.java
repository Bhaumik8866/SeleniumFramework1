package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class schedulerWindow {
	
	public WebDriver driver;
	
	private By paramtab=By.xpath("//div[@aria-posinset='1']");
	private By scheduletab=By.xpath("//div[@aria-posinset='2']");
	private By outputtab=By.xpath("//div[@aria-posinset='3']");
	private By runbutton=By.xpath("//span[text()='Run']");
	private By outputname=By.xpath("//input[@name='soutputname']");
	private By outputformat=By.xpath("//mat-select[@name='otformat']");
	//span[text()='Right Now']
	private By oncedatetimepicker=By.xpath("//input[contains(@id,'ej2-datetimepicker')]");
	private By scheduletypedropdown=By.xpath("//span[text()='Time']");
	private By scheduletypeevent=By.xpath("//span[text()='Event']");
	private By eventdropdown=By.xpath("//span[text()='Create/Manage Events']");
	private By eventcreatebutton=By.xpath("//a[contains(@class,'tg_event_icon')]");
	private By eventnumber=By.xpath("//input[@name='event_number']");
	private By eventtype=By.xpath("//input[@name='type']");
	private By eventdescription=By.xpath("//input[@name='description']");
	private By eventsubmitbutton=By.xpath("//button[@type='submit']");
	//Event created successfully
	private By eventcreatedmessage=By.xpath("//*[text()='Event created successfully']");
	private By eventonsuccesslist=By.xpath("//mat-select[@name='successid']");
	private By eventonfaillist=By.xpath("//mat-select[@name='failid']");
	private By faileventoption=By.xpath("//span[text()=' None ']");
	//i[@class='icon-delete']
	private By eventdeleteicon=By.xpath("//i[@class='icon-delete']");
	
	//Delete successfully
	private By eventdeletemessage=By.xpath("//*[text()='Delete successfully']");
	
	
	public schedulerWindow(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement paramtab()
	{
		return driver.findElement(paramtab);
	}
	
	public WebElement scheduletab()
	{
		return driver.findElement(scheduletab);
	}
	public WebElement outputtab()
	{
		return driver.findElement(outputtab);
	}
	public WebElement runbutton()
	{
		return driver.findElement(runbutton);
	}
	public WebElement outputname()
	{
		return driver.findElement(outputname);
	}
	public WebElement outputformat()
	{
		return driver.findElement(outputformat);
	}
	public WebElement selectoutputformatlist(String outputformat)
	{
		return driver.findElement(By.xpath("//span[text()='"+" "+outputformat+" "+"']"));
	}
	
	public WebElement schedulefrequency(String frequnecy) //span[text()='Right Now']
	{
		return driver.findElement(By.xpath("//span[text()='"+frequnecy+"']"));
	}
	public WebElement oncedatetimepicker()
	{
		return driver.findElement(oncedatetimepicker);
	}
	public WebElement scheduletypedropdown()
	{
		return driver.findElement(scheduletypedropdown);
	}
	public WebElement scheduletypeevent()
	{
		return driver.findElement(scheduletypeevent);
	}
	public WebElement eventdropdown()
	{
		return driver.findElement(eventdropdown);
	}
	public WebElement eventcreatebutton()
	{
		return driver.findElement(eventcreatebutton);
	}
	
	public WebElement eventnumber()
	{
		return driver.findElement(eventnumber);
	}
	public WebElement eventtype()
	{
		return driver.findElement(eventtype);
	}
	public WebElement eventdescription()
	{
		return driver.findElement(eventdescription);
	}
	public WebElement eventsubmitbutton()
	{
		return driver.findElement(eventsubmitbutton);
	}
	public WebElement eventcreatedmessage()
	{
		return driver.findElement(eventcreatedmessage);
	}
	
//	private By selecteventoption=By.xpath("//span[text()=' 2. Email ']");
	public WebElement selecteventoption(String eventname)
	{
		return driver.findElement(By.xpath("//span[text()='"+" "+eventname+" "+"']"));
	}
//	private By eventonsuccesslist=By.xpath("//mat-select[@name='successid']");
	public WebElement eventonsuccesslist()
	{
		return driver.findElement(eventonsuccesslist);
	}
//	private By eventonfaillist=By.xpath("//mat-select[@name='failid']");
	public WebElement eventonfaillist()
	{
		return driver.findElement(eventonfaillist);
	}
	//span[text()=' 2 ']
	public WebElement successeventid(String eventid)
	{
		return driver.findElement(By.xpath("//span[text()='"+" "+eventid+" "+"']"));
	}
	
	public WebElement faileventoption()
	{
		return driver.findElement(faileventoption);
	}
	//private By eventdeleteicon=By.xpath("//i[@class='icon-delete']");
	public WebElement eventdeleteicon()
	{
		return driver.findElement(eventdeleteicon);
	}
	public WebElement eventdeletemessage()
	{
		return driver.findElement(eventdeletemessage);
	}
}
