package com.seleniumPractice;

import java.time.Duration;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String userName = "Dinnu";
//		System.setProperty("webdriver.edge.driver",".\\Resources\\msedgedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String password = getPassword(driver);
		
		driver.findElement(By.className("go-to-login-btn")).click();
		
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
//		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div h2")).getText(),"Hello "+userName+",");
//		driver.navigate().refresh();
//		driver.navigate().back();
//		Thread.sleep(2000);
//		driver.navigate().forward();
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(1000);
		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.partialLinkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwordMessage = driver.findElement(By.xpath("//form/p")).getText();
		String[] passwordArray = passwordMessage.split("'")[1].split("'");
		String password = passwordArray[0];
		return password;
	}

	
}
