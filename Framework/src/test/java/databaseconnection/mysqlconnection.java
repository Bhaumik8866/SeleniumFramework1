package databaseconnection;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.initializeDriver;

public class mysqlconnection extends initializeDriver{
	
	public static WebDriver driver;
	
 
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		
		// TODO Auto-generated method stub
		initializeDriver init=new initializeDriver();

		String host="localhost";

		String port= "3306";

		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/sakila", "root", "1234");

		Statement s=con.createStatement();

		ResultSet rs=s.executeQuery("select * from address where address_id ='1'");

		while(rs.next())

		{

		driver=init.driverinit();

		driver.get("https://login.salesforce.com");

		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("address_id"));

		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("district"));

		}
	}
}
