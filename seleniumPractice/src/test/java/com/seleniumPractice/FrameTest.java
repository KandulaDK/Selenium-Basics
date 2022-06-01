package com.seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		dinnu.manage().window().maximize();
		dinnu.get("https://jqueryui.com/droppable/");

		dinnu.switchTo().frame(dinnu.findElement(By.cssSelector("iframe.demo-frame")));
		
		Actions a = new Actions(dinnu);
		WebElement sources = dinnu.findElement(By.id("draggable"));
		WebElement targets = dinnu.findElement(By.id("droppable"));
		
		Thread.sleep(1000);
		a.dragAndDrop(sources,targets).build().perform();
		
		Thread.sleep(2000);
		dinnu.switchTo().defaultContent();
		dinnu.findElement(By.xpath("//a[.='Accept']")).click();
	}

}
