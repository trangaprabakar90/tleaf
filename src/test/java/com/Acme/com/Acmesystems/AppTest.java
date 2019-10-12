package com.Acme.com.Acmesystems;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AppTest {
	public static ChromeDriver driver;
	@Test
    public void testApp() {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		WebElement vendor = driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");
		Actions builder=new Actions(driver);
		builder.moveToElement(vendor).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		WebElement loccoun = driver.findElement(By.xpath("//td[text()='France']"));
		String text = loccoun.getText();
		System.out.println(text);
		
		
    	
    	
    }
}
