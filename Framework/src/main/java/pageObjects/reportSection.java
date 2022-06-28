package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class reportSection {
	WebDriver driver;
	public static Actions act;
	
	private By templateFolder=By.xpath("//div[text()=' Templates ']/parent::td");
	
	////span[text()='Owner']/parent::div/parent::th/div[3]
	
	private By ownerFiltericon=By.xpath("//span[text()='Owner']/parent::div/parent::th/div[3]");
	
	// //input[@aria-placeholder='Search']
	
	private By filtersearch=By.xpath("//input[@aria-placeholder='Search']");
	
	// //button[text()='OK']
	
	private By filterokbutton=By.xpath("//button[text()='OK']");
	
	private By annotationreportperiod=By.xpath("//mat-select[@id='Period']");
	
	private By annotationreportcoverpageimage=By.xpath("//mat-select[@id='CoverPageImage']");
	
	private By annotationreportreporttitle=By.xpath("//input[@id='ReportTitle']");
	
	private By customerdetailscustomername=By.xpath("//input[@id='rp_Customer Name']");
	
	private By customerdetailscountry=By.xpath("//input[@id='country']");
	
	private By invoicecustomernumber=By.xpath("//input[@id='Customer Number']");
	
	private By orderdetailsordernumber=By.xpath("//input[@id='OrderNumber']");
	
	private By renreporticons=By.xpath("//div[@class='aiv_runrep_htp_left']");
	
	//Event updated
	private By eventsuccessmessage=By.xpath("//*[text()='Event updated']");
	
	private By createfolderfooter=By.xpath("//span[@translate='createFile_Create']");
	
	private By createfolderwindow=By.xpath("//p[@class='modal_header_title modal_title_on']");
	
	private By createfoldercreatebutton=By.xpath("//button[@disabled='true']");
	
	private By nonamevalidation=By.xpath("//span[text()='Name is required !!!']");
	
	private By createfoldertext=By.xpath("//input[@name='name']");
	
	private By foldersuccessmessage=By.xpath("//*[text()='Folder created Successfully']");
	
	private By createfolderbuttonenabled=By.xpath("//button[@type='submit']");
	
	
	public reportSection(WebDriver driver2) {
		this.driver=driver2;
		act=new Actions(this.driver);
	}

	public WebElement templateFolder()
	{
		return driver.findElement(templateFolder);
	}
	
	public WebElement reportName(String name)
	{
		return driver.findElement(By.xpath("//div[text()='"+" "+name+" "+"']"));
	}

	public WebElement ownerFiltericon()
	{
		return driver.findElement(ownerFiltericon);
	}
	
	public WebElement filtersearch()
	{
		return driver.findElement(filtersearch);
	}
	public WebElement filterokbutton()
	{
		return driver.findElement(filterokbutton);
	}
	
	public WebElement annotationreportperiod()
	{
		return driver.findElement(annotationreportperiod);
	}
	public WebElement annotationreportcoverpageimage()
	{
		return driver.findElement(annotationreportcoverpageimage);
	}
	public WebElement annotationreportreporttitle()
	{
		return driver.findElement(annotationreportreporttitle);
	}
	public WebElement periodoption(String name)
	{
		// //span[text()=' Daily ']
		return driver.findElement(By.xpath("//span[text()='"+" "+name+" "+"']"));
	}
	public WebElement coverpageoption(String name1)
	{
		// //span[text()=' Fruits ']
//		System.out.println("xpath called:"+By.xpath("//span[text()='"+" "+name1+" "+"']"));
		return driver.findElement(By.xpath("//span[text()='"+" "+name1+" "+"']"));
	}
	public WebElement customerdetailscustomername()
	{
		return driver.findElement(customerdetailscustomername);
	}
	
	public WebElement customerdetailscountry()
	{
		return driver.findElement(customerdetailscountry);
	}
	
	public WebElement invoicecustomernumber()
	{
		return driver.findElement(invoicecustomernumber);
	}
	public WebElement orderdetailsordernumber()
	{
		return driver.findElement(orderdetailsordernumber);
	}
	
	public WebElement renreporticons()
	{
		return driver.findElement(renreporticons);
	}
	
	public WebElement eventsuccessmessage()
	{
		return driver.findElement(eventsuccessmessage);
	}
	public WebElement scheduleoutputoption(String reportname,String outputformat)
	{
		//div[text()=' Annotations ']/parent::td/following-sibling::td[6]//a//img[contains(@src,'rptdocument')]
		
		return driver.findElement(By.xpath("//div[text()='"+" "+reportname+" "+"']/parent::td/following-sibling::td[6]//a//img[contains(@src,'"+outputformat+"')]"));
	}
	
	public WebElement xlsxoptionicon(String reportname)
	{
		//div[text()=' Annotations ']/parent::td/following-sibling::td[6]//a//img[contains(@src,'rptdocument')]
		
		return driver.findElement(By.xpath("//div[text()='"+" "+reportname+" "+"']/parent::td/following-sibling::td[6]//a//img[@src='assets/images/icons/xlsx.svg']"));
	}
	
	public WebElement phtmloptionicon(String reportname)
	{
		//div[text()=' Annotations ']/parent::td/following-sibling::td[6]//a//img[contains(@src,'rptdocument')]
		
		return driver.findElement(By.xpath("//div[text()='"+" "+reportname+" "+"']/parent::td/following-sibling::td[6]//a//img[@src='assets/images/icons/phtml.svg']"));
	}
	public WebElement htmloptionicon(String reportname)
	{
		//div[text()=' Annotations ']/parent::td/following-sibling::td[6]//a//img[contains(@src,'rptdocument')]
		
		return driver.findElement(By.xpath("//div[text()='"+" "+reportname+" "+"']/parent::td/following-sibling::td[6]//a//img[@src='assets/images/icons/html.svg']"));
	}
	
	public WebElement createfolderfooter()
	{
		return driver.findElement(createfolderfooter);
	}
	
	public WebElement createfolderwindow()
	{
		return driver.findElement(createfolderwindow);
	}
	
	
	public WebElement createfoldercreatebutton()
	{
		return driver.findElement(createfoldercreatebutton);
	}
	
	//private By nonamevalidation=By.xpath("//span[text()='Name is required !!!']");
	public WebElement nonamevalidation()
	{
		return driver.findElement(nonamevalidation);
	}
	
	//private By createfoldertext=By.xpath("//input[@name='name']");
	public WebElement createfoldertext()
	{
		return driver.findElement(createfoldertext);
	}
	
	//private By foldersuccessmessage=By.xpath("//*[text()='Folder created Successfully']");
	public WebElement foldersuccessmessage()
	{
		return driver.findElement(foldersuccessmessage);
	}
	
	//private By createfolderenabled=By.xpath("//button[@type='submit']");
	
	public WebElement createfolderbuttonenabled()
	{
		return driver.findElement(createfolderbuttonenabled);
	}
	
	//div[text()=' Automation_Test 8 ']/parent::td
	
	public WebElement folderselect(String name1)
	{
		return driver.findElement(By.xpath("//div[text()='"+" "+name1+" "+"']/parent::td"));
	}
	public void deletefolder(String name1) throws InterruptedException
	{
		act.contextClick(driver.findElement(By.xpath("//div[text()='"+" "+name1+" "+"']/parent::td"))).build().perform();
		driver.findElement(By.xpath("//li[@id='delete']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='modal_header_title modal_title_on']/span")).getText(), "Delete");
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(@class,'ais_confrmt_txt ')]")).getText(), "Are you sure you want to delete ? This action cannot be undone");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='mat-checkbox-label']//span[@class='mat-tooltip-trigger']")).getText(), name1);
		driver.findElement(By.xpath("//span[@translate='label_all_versions']")).click();
		driver.findElement(By.xpath("//span[text()='"+name1+"']")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//button[@disabled='true']")).isDisplayed());
		driver.findElement(By.xpath("//span[text()='"+name1+"']")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//span[@translate='context_menu_common_delete']")).isEnabled());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//span[@translate='context_menu_common_delete']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Delete successfully']")).getText(), "Delete successfully");
		
	}
}

