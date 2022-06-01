package com.seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String name = "Dinesh Kumar";
		WebDriverManager.chromedriver().setup();
		WebDriver bunny = new ChromeDriver();
		bunny.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		bunny.get("https://rahulshettyacademy.com/AutomationPractice/");
		bunny.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
		bunny.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(bunny.switchTo().alert().getText());
		bunny.switchTo().alert().accept();
		bunny.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
		bunny.findElement(By.id("confirmbtn")).click();
		System.out.println(bunny.switchTo().alert().getText());
		bunny.switchTo().alert().dismiss();
		
//		bunny.manage().window().maximize();
//		
//		bunny.get("https://www.flipkart.com/");
//		bunny.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
//		Actions a = new Actions(bunny);
//		a.moveToElement(bunny.findElement(By.xpath("//div[contains(text(),'Beauty, Toys & More')]"))).build().perform();
//		
//		bunny.findElement(By.cssSelector("._6WOcW9._2-k99T")).click();
		
		
//		bunny.close();
		

	}

}
