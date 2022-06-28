package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class initializeDriver {

	public WebDriver driver;
	public Properties prop;
	public WebDriver driverinit() throws IOException
	{
		
		prop=new Properties();
		//System.getProperty("user.dir");
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		prop.load(fis);
		//mvn test -Dbrowser=chrome
//		String browser= System.getProperty("browser");
		String browser=prop.getProperty("browser");
		System.out.println("Test is Running in "+browser);
		
		if(browser.contains("chrome"))
		{
			//chrome driver code
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			
			if(browser.contains("headless")) {
			options.addArguments("--headless");
			}
			driver= new ChromeDriver(options);
			
		}
//		else if (browser.equalsIgnoreCase("firefox"))
//		{
//			//firefox driver code
//			System.setProperty("webdriver.chrome.driver", "C:\\Bhaumik\\Selenium Files\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//			driver= new FirefoxDriver();
//		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			//edge driver code
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
