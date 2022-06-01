package com.seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		WebDriver dinnu = new ChromeDriver();
//		
//		dinnu.manage().window().maximize();
		
//		dinnu.get("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");
//		WebElement staticDropdown = dinnu.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
//		Select dropdown = new Select(staticDropdown);
//		dropdown.selectByIndex(3);
//		System.out.println(dropdown.getFirstSelectedOption().getText());
//		dropdown.selectByVisibleText("AED");
//		System.out.println(dropdown.getFirstSelectedOption().getText());
//		dropdown.selectByValue("INR");
//		System.out.println(dropdown.getFirstSelectedOption().getText());		
	}
	
	public  void staticDrop(WebDriver dinnu) {
		WebElement staticDropdown = dinnu.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

}
