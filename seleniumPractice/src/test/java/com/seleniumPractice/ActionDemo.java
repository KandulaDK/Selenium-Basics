package com.seleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		dinnu.get("https://www.amazon.in/");
		
		Actions a = new Actions(dinnu);
		
		//dinnu.findElement(By.id("twotabsearchtextbox")).sendKeys("HELLO");
		
		//got search box click on search box, hold shift enter hello and by double clicking text will selected
		a.moveToElement(dinnu.findElement(By.id("twotabsearchtextbox"))).click()
		.keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		//moves to specific element
		a.moveToElement(dinnu.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
	
//-----------------------------------------------------------------------------------		
		dinnu.switchTo().newWindow(WindowType.TAB);
		
		Set<String> activeW = dinnu.getWindowHandles();
		Iterator<String> it = activeW.iterator();
		String parent = it.next();
		String child = it.next();
		
		dinnu.switchTo().window(child);
		dinnu.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
//		mouse hover practice 

		Actions a1 = new Actions(dinnu);
//		
		a1.moveToElement(dinnu.findElement(By.id("mousehover"))).build().perform();
//		
		Thread.sleep(2000);
		a1.moveToElement(dinnu.findElement(By.xpath("//a[.='Reload']"))).build().perform();
		Thread.sleep(2000);
		a1.moveToElement(dinnu.findElement(By.xpath("//a[.='Top']"))).build().perform();
		Thread.sleep(2000);
		a1.click().build().perform();
		
	}

}
