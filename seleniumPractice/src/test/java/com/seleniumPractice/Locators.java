package com.seleniumPractice;

import java.time.Duration;

//import javax.sound.midi.SysexMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 
		//System.setProperty("webdriver.chrome.driver",".\\Resources\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Implicity Wait
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Dinnu");
		driver.findElement(By.name("inputPassword")).sendKeys("Hello123");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		driver.findElement(By.className("signInBtn")).click();
		String errorMsg = driver.findElement(By.cssSelector("p.error")).getText();
		Assert.assertEquals(errorMsg, "* Incorrect username or password");
		driver.findElement(By.partialLinkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Dinesh");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("1234abcd@hotmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abcd@hotmaail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("987654321");
		driver.findElement(By.className("reset-pwd-btn")).click();
		//System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//form/p")).getText(), "Please use temporary password 'rahulshettyacademy' to Login.");
		
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Dinnu");
		driver.findElement(By.cssSelector("input[type*=\"Pass\"]")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span/input[@name='chkboxOne']")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("logout-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("visitUsTwo")).click();
	}  

}
