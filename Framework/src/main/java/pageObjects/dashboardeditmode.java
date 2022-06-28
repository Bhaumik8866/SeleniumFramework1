package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardeditmode {

	public dashboardeditmode(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public WebDriver driver;
	
	private By reportwidgeticon=By.xpath("//ul[contains(@class,'aiv_nav_vertical_scrollbaron')]//li[4]//a//i");
	
	private By dashboardpreviewbutton=By.xpath("//i[contains(@class,'fa-play')]");
	
	public WebElement reportwidgeticon()
	{
		return driver.findElement(reportwidgeticon);
	}	
	public WebElement dashboardpreviewbutton()
	{
		return driver.findElement(dashboardpreviewbutton);
	}	
}
