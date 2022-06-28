package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	By username=By.xpath("//input[@name='username']");
	By password=By.xpath("//input[@type='password']");
	By login=By.xpath("//button[@color='primary']");
	
	public loginPage(WebDriver driver2) {
		
		this.driver=driver2;
	}


	public WebElement UserName()
	{
		return driver.findElement(username);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement login()
	{
		return driver.findElement(login);
	}

}
