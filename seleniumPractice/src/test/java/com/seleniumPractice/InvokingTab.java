package com.seleniumPractice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokingTab {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * Invoking Multiple Windows/Tabs from Selenium using one driver Instance I
		 * Scenario: Navigate to https://rahulshettyacademy.com/angularpractice/ 
		 * Fill the"Name"field with the first course name available at
		 * https://rahulshettyacademy.com
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
		dinnu.get("https://rahulshettyacademy.com/angularpractice/");
		
		//opening an empty tab in the browser
		dinnu.switchTo().newWindow(WindowType.TAB);
		
		Set<String> open = dinnu.getWindowHandles();
		Iterator<String> it = open.iterator();
		String parent = it.next();		
		String child = it.next();
		dinnu.switchTo().window(child);
		
		dinnu.get("https://rahulshettyacademy.com");
		String course = dinnu.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		System.out.println(course);
		
		dinnu.switchTo().window(parent);

		WebElement nameInput = dinnu.findElement(By.cssSelector("[name='name']"));
		nameInput.sendKeys(course);
		
		//takes full page screenshot
		File src =  ((TakesScreenshot)dinnu).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("screenshot1.png"));
		
		//takes specific element screenshot
		File file = nameInput.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		
		//get height and width of element
		System.out.println(nameInput.getRect().getDimension().getHeight());
		System.out.println(nameInput.getRect().getDimension().getWidth());
		
		

	}

}
