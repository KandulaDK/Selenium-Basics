package com.seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
		dinnu.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement inputName = dinnu.findElement(By.cssSelector("input[name='name']"));
		
		System.out.println(dinnu.findElement(RelativeLocator.with(By.tagName("label")).above(inputName)).getText());
		
		WebElement dateLabel = dinnu.findElement(By.cssSelector("[for='dateofBirth']"));
	
		dinnu.findElement(RelativeLocator.with(By.tagName("input")).below(dateLabel)).click();
		
		WebElement checkBoxLabel = dinnu.findElement(By.xpath("//label[contains(.,'IceCreams!')]"));
		
		dinnu.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(checkBoxLabel)).click();

		WebElement radio = dinnu.findElement(By.id("inlineRadio1"));
		
		System.out.println(dinnu.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(radio)).getText());
	}
	

}
