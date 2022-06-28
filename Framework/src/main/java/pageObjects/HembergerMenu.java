package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HembergerMenu {
	WebDriver driver;
	
	private By hembergerbutton=By.xpath("//button[@class='smenu_button']");
	private By dashboardNewPage=By.cssSelector("a[href='/aiv/Visualization/GridDashboard'][target*='blank']");
	private By annotation=By.cssSelector("a[href='/aiv/Annotation']");
	private By theme=By.cssSelector("a[href='/aiv/aivTheme']");
	private By controlPanel=By.cssSelector("a[href='/aiv/controlpanel']");
	private By logout=By.cssSelector("span[translate='mainHeader_Logout']");
	private By documentsection=By.xpath("//*[text()='Documents']/parent::span");
	private By report=By.xpath("//*[text()='Reports']");
	private By requestsection=By.xpath("//mat-panel-title[text()='Request']");
	private By request=By.xpath("//span[text()='Request']");
	
	private By dashboardsection=By.xpath("//mat-panel-title[text()='Dashboard']");
	private By createdashboardicon=By.xpath("//a[@title='Create Dashboard']");
	private By dashboardgridicon=By.xpath("//a[@href='/aiv/Visualization/GridDashboard'][@title='List View']");
	private By dashboardopeninnewtab=By.xpath("//a[@href='/aiv/Visualization/GridDashboard'][@title='Open in new tab']");
	
	public HembergerMenu(WebDriver driver2) {
		this.driver=driver2;
	}


	public WebElement hembergerbutton()
	{
		return driver.findElement(hembergerbutton);
	}

	public WebElement dashboardNewPage()
	{
		return driver.findElement(dashboardNewPage);
	}
	
	public WebElement annotation()
	{
		return driver.findElement(annotation);
	}
	public WebElement theme()
	{
		return driver.findElement(theme);
	}
	public WebElement controlPanel()
	{
		return driver.findElement(controlPanel);
	}
	public WebElement logout()
	{
		return driver.findElement(logout);
	}
	public WebElement documentSection()
	{
		return driver.findElement(documentsection);
	}
	public WebElement report()
	{
		return driver.findElement(report);
	}
	public WebElement requestsection()
	{
		return driver.findElement(requestsection);
	}
	public WebElement request()
	{
		return driver.findElement(request);
	}	
	
//	private By dashboardsection=By.xpath("//mat-panel-title[text()='Dashboard']");
	public WebElement dashboardsection()
	{
		return driver.findElement(dashboardsection);
	}	
//	private By createdashboardicon=By.xpath("//a[@title='Create Dashboard']");
	public WebElement createdashboardicon()
	{
		return driver.findElement(createdashboardicon);
	}	
//	private By dashboardgridicon=By.xpath("//a[@href='/aiv/Visualization/GridDashboard'][@title='List View']");
	public WebElement dashboardgridicon()
	{
		return driver.findElement(dashboardgridicon);
	}
//	private By dashboardopeninnewtab=By.xpath("//a[@href='/aiv/Visualization/GridDashboard'][@title='Open in new tab']");
	public WebElement dashboardopeninnewtab()
	{
		return driver.findElement(dashboardopeninnewtab);
	}
}
