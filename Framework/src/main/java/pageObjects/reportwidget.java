package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class reportwidget {
	
	public reportwidget(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public WebDriver driver;
	
	private By selecttemplatefolder=By.xpath("//label[text()='Templates']/parent::div/button");
	private By charlength255report=By.xpath("//label[text()=' charlength255.rptdesign ']");
	private By reportoutputtype=By.xpath("//span[text()='None']");
	private By reporttypehtml=By.xpath("//span[text()=' html ']");
	private By previewbutton=By.xpath("//span[text()='Preview']");
	private By saveandexitbutton=By.xpath("//span[text()='Save and Exit']");
	
	public WebElement selecttemplatefolder()
	{
		return driver.findElement(selecttemplatefolder);
	}	

	public WebElement charlength255report()
	{
		return driver.findElement(charlength255report);
	}	
	public WebElement reportoutputtype()
	{
		return driver.findElement(reportoutputtype);
	}	
	public WebElement reporttypehtml()
	{
		return driver.findElement(reporttypehtml);
	}	
	public WebElement previewbutton()
	{
		return driver.findElement(previewbutton);
	}	
	public WebElement saveandexitbutton()
	{
		return driver.findElement(saveandexitbutton);
	}
}
