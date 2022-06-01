package com.seleniumPractice;

//import java.time.Duration;
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitExplicit {

//	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
		dinnu.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		
		////dinnu.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Implicitly Wait
		
		//Explicitly Wait
		//WebDriverWait
		///WebDriverWait explicitWait = new WebDriverWait(dinnu, Duration.ofSeconds(7));
		
		////explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("element_id)")));
		
		//Fluent Wait
		
		dinnu.findElement(By.cssSelector("div[id='start'] button")).click();
		
//		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(dinnu).withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//		
//		WebElement foo = fluentWait.until(new Function <WebDriver,WebElement>() {
//			      public WebElement apply(WebDriver dinnu){
//			    	  if (dinnu.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
//			    		  return dinnu.findElement(By.cssSelector("[id='finish'] h4"));
//			    	  }else {
//			    		  return null;
//			    	  }
//			    	  
//			     }
//		}); //-------Flent Wait
		
		System.out.println(dinnu.findElement(By.cssSelector("[id='finish'] h4")).getText());

	}

}
