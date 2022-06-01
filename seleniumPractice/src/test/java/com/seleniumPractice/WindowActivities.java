package com.seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowActivities {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
		dinnu.manage().window().maximize();
		dinnu.get("https://www.google.com/");
		dinnu.navigate().to("https://www.amazon.com");
		dinnu.navigate().back();
		dinnu.navigate().forward();
		dinnu.manage().window().minimize();
		dinnu.manage().window().maximize();
	
	}
}
