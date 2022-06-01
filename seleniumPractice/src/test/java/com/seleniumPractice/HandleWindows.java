package com.seleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();

		dinnu.get("https://www.rahulshettyacademy.com/loginpagePractise/");

		dinnu.findElement(By.className("blinkingText")).click();

		Set<String> liveWindows = dinnu.getWindowHandles(); // [parentId,ChildId]
		Iterator<String> it = liveWindows.iterator();
//		System.out.println(it);
		String parent = it.next();
		String child = it.next();
		dinnu.switchTo().window(child);
		System.out.println(dinnu.findElement(By.xpath("//div[@class='col-md-6 text-left'] //h3 //span")).getText());
		String rest = dinnu.findElement(By.xpath("//div[@class='col-md-6 text-left'] //h3 //span")).getText()
				.split(",")[1].trim();
		System.out.println(rest);
		dinnu.switchTo().window(parent);
		dinnu.findElement(By.id("username")).sendKeys(rest);
		dinnu.switchTo().window(child);
		dinnu.findElement(By.partialLinkText("Blog")).click();
		String pswd = dinnu.findElement(By.cssSelector("h3[data-css*='tve-u-17ade']")).getText();
		dinnu.switchTo().window(parent);
		dinnu.findElement(By.id("password")).sendKeys(pswd);
		dinnu.findElement(By.id("signInBtn")).click();
		
		dinnu.switchTo().window(child);
		dinnu.close(); //active window but quit() complete browser
	}

}
