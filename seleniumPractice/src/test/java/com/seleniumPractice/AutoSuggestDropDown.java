package com.seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();		
		dinnu.get("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");
		dinnu.findElement(By.id("autosuggest")).sendKeys("ind"); //id locator
		Thread.sleep(2000);
		List<WebElement> options = dinnu.findElements(By.cssSelector("li[class='ui-menu-item'] a")); //list of webelemets
		
		for (WebElement option : options) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		
		
	}

}
