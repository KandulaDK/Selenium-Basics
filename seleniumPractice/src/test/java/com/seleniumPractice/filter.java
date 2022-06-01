package com.seleniumPractice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();

		dinnu.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		dinnu.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> li = dinnu.findElements(By.xpath("//tr //td[1]"));
		
		List<WebElement> filteredList = li.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(li.size(), filteredList.size());
	}

}
