package com.seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksAndSoftAsserts {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
		dinnu.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		//get all url's tied up to the links using selenium
		//java methods will call URL's and gets you the status code
		//if status code is greater than 400 then that url is not working
		// that url is called the broken url which is tied up to that link
		
		//xpath "//a[contains(@href,'jmeter')]" --- css "a[href*='jmeter']"
		
//		String url = dinnu.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href");
		
		
		
		//fotter section links css = "[class*='footer'] a"
		
		List<WebElement> links	= dinnu.findElements(By.cssSelector("[class*='footer'] a"));
	
		SoftAssert sa = new SoftAssert();
		
		
		for(WebElement eachLink : links) {
			String linkurl = eachLink.getAttribute("href");
			
//			HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
//			
//			conn.setRequestMethod("HEAD");
//			conn.connect();
//			System.out.println(conn.getResponseMessage());
//			int responseCode = conn.getResponseCode();
//			System.out.println(responseCode);
			
			
			URL url = new URL(linkurl);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpURLConnection =  (HttpURLConnection) urlConnection;
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			int responseCode = httpURLConnection.getResponseCode();
			 
			sa.assertTrue(responseCode == 200, "The broken link text: " + eachLink.getText()+ " with response code of " + responseCode + httpURLConnection.getResponseMessage());

//			if(responseCode >= 400) {
//				System.out.println("The broken link text: " + eachLink.getText()+ " with response code of " + responseCode);
////				Assert.assertTrue(false);
//			}
			httpURLConnection.disconnect();
			
		}
		dinnu.quit();
		sa.assertAll();
	}

}
