package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardGrid {
	
	public dashboardGrid(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public WebDriver driver;
	
	private By automationtestfolder=By.xpath("//div[text()=' Automation Test ']");
	private By reportwidgetfolder=By.xpath("//div[text()=' report widget test ']");
	private By createdashboardfooter=By.xpath("//i[@class='icon-dashboard2']");
	private By createdashboardname=By.xpath("//input[@name='name']");
	//span[@translate='create_File_dashboard']
	private By createdashboardbutton=By.xpath("//span[@translate='create_File_dashboard']");
	
	//span[text()='Delete']
	private By deletedashboardfooter=By.xpath("//span[text()='Delete']");
	//span[text()='All versions']
	private By deletedialogboxallversioncheckbox=By.xpath("//span[text()='All versions']");
	//span[@class='mat-button-wrapper']//span[text()='Delete']
	private By deletedialogboxdelete=By.xpath("//span[@class='mat-button-wrapper']//span[text()='Delete']");
	
	public WebElement automationtestfolder()
	{
		return driver.findElement(automationtestfolder);
	}
	
	public WebElement reportwidgetfolder()
	{
		return driver.findElement(reportwidgetfolder);
	}
	public WebElement createdashboardfooter()
	{
		return driver.findElement(createdashboardfooter);
	}
	public WebElement createdashboardname()
	{
		return driver.findElement(createdashboardname);
	}
	public WebElement createdashboardbutton()
	{
		return driver.findElement(createdashboardbutton);
	}
	public WebElement deletedashboardfooter()
	{
		return driver.findElement(deletedashboardfooter);
	}
	public WebElement deletedialogboxallversioncheckbox()
	{
		return driver.findElement(deletedialogboxallversioncheckbox);
	}
	public WebElement deletedialogboxdelete()
	{
		return driver.findElement(deletedialogboxdelete);
	}

}
