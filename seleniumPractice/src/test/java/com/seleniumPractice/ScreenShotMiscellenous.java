package com.seleniumPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotMiscellenous {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		dinnu.manage().window().maximize();
		dinnu.get("https://www.youtube.com");
		
		JavascriptExecutor js = (JavascriptExecutor)dinnu;
		js.executeScript("window.scrollBy(0,300)");
		
		File src = ((TakesScreenshot)dinnu).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\DinnuBunny\\Music/screenshot1.png"));
		
		dinnu.quit();
	}

}
