package fmsview.autotest;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.*;

public class SearchPageTest {


  WebDriver driver ;

	@BeforeTest
	public void setUpBrowser()
	{
		String os = System.getProperty("os.name").toLowerCase();

		if(os.contains("mac"))

		{
		System.setProperty("webdriver.chrome.driver", "selenium-drivers/chromedriver");
	    driver = new ChromeDriver();  // system pro
		}
	    else
	    {
	    	System.setProperty("webdriver.chrome.driver", "selenium-drivers/chromedriver.exe");
		    driver = new ChromeDriver();
	    }

		}

	//0. Verify you get a 200 response from the website.
	@Test(priority=1)
	public void getHTTPResponseCodeOfURL(String url)
	{

		  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		  // put your comment here for your test
      Assert.assertEquals(RestAssured.get("http://fmsview.mtc.ca.gov").statusCode(),"200");

   }



	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}


}
