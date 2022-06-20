package com.seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practicing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//-----------action class---------
		driver.get("https://www.globalsqa.com/demo-site/auto-complete/");
		
		WebElement box = driver.findElement(By.xpath("//div[@class='container startNow'] //div[@rel-title='Categories'] //iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(box);
		
		
		
		Actions a = new Actions(driver);
		WebElement inputBox = driver.findElement(By.id("search"));
		a.sendKeys(inputBox, "an");
		//anders andersson
		
		do {
			a.sendKeys(Keys.DOWN).build().perform();
		}while(!inputBox.getAttribute("value").equalsIgnoreCase("anders andersson"));
			
		a.sendKeys(Keys.ENTER).build().perform();
		
		
		
		//----------frag and drop----------
//		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
//		
//		driver.findElement(By.id("Propagation")).click();
//		
//		WebElement box = driver.findElement(By.xpath("//div[@rel-title='Propagation'] //iframe[@class='demo-frame lazyloaded']"));
//		//(//iframe[@class='demo-frame lazyloaded'])[2]
//		
//		driver.switchTo().frame(box);
//		
//		WebElement colA = driver.findElement(By.id("draggable"));
//		WebElement colB = driver.findElement(By.id("droppable2-inner"));
//		
//		Actions a = new Actions(driver);
//		
//		a.dragAndDrop(colA, colB).build().perform();
////		a.dragAndDrop(colA.get(1), colB).build().perform();
////		a.dragAndDrop(colA.get(2), colB).build().perform();
		

		//-----------url connections--------
//		driver.get("https://the-internet.herokuapp.com/status_codes");
//		List<WebElement> images = driver.findElements(By.xpath("//a[contains(@href,'status_codes')]"));
//
//		for (WebElement image : images) {
//			String link = image.getAttribute("href");
//
//			try {
//				URL url = new URL(link);
//				URLConnection urlcon = url.openConnection();
//				HttpURLConnection httpURLConnection = (HttpURLConnection) urlcon;
//				httpURLConnection.setConnectTimeout(5000);
//				httpURLConnection.connect();
//
//				if (httpURLConnection.getResponseCode() == 200) {
//					System.out.println(httpURLConnection.getResponseCode()+" : "+httpURLConnection.getResponseMessage());
//				} else {
//					System.err.println(httpURLConnection.getResponseCode()+" : "+httpURLConnection.getResponseMessage());
//				}
//				httpURLConnection.disconnect();
//			} catch (IOException e) {
//				System.err.println(link);
//			}
//
//		}
//		driver.quit();
	}

}
