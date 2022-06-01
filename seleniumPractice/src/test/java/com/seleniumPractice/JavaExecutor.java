package com.seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();

		dinnu.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)dinnu;
		
		js.executeScript("window.scrollBy(0,750)");
		
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=500");
		
		List<WebElement> fixHeadTable = dinnu.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int summ = 0;
		for(int i=0;i<fixHeadTable.size();i++) {
			
			int value = Integer.parseInt(fixHeadTable.get(i).getText());
			summ = summ + value;
		}
		System.out.println(summ);
		
		String num = dinnu.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		
		int n = Integer.parseInt(num);
		
		System.out.println(n);
		
		Assert.assertEquals(summ, n);
		
	}

}
