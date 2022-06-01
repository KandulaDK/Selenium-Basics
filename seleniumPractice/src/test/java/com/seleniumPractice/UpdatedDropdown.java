package com.seleniumPractice;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
//		dinnu.manage().window().maximize();
		
		dinnu.get("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");
		
//		Assert.assertFalse(dinnu.findElement(By.cssSelector("input[name*='StudentDiscount']")).isSelected());
////		System.out.println(dinnu.findElement(By.cssSelector("input[name*='StudentDiscount']")).isSelected());
//		dinnu.findElement(By.cssSelector("input[name*='StudentDiscount']")).click();
////		System.out.println(dinnu.findElement(By.cssSelector("input[name*='StudentDiscount']")).isSelected());
//		Assert.assertTrue(dinnu.findElement(By.cssSelector("input[name*='StudentDiscount']")).isSelected());
//		System.out.println("checkbox size: "+ dinnu.findElements(By.xpath("//input[@type='checkbox']")).size());
//		Assert.assertEquals(dinnu.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);
		
		System.out.println(dinnu.findElement(By.id("Div1")).getAttribute("Style"));
		dinnu.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//System.out.println(dinnu.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		System.out.println(dinnu.findElement(By.id("Div1")).getAttribute("Style"));
		if (dinnu.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		
//		dinnu.findElement(By.id("divpaxinfo")).click();
//		Thread.sleep(1500);
//		for (int i = 1; i<5; i++) {
//			dinnu.findElement(By.id("hrefIncAdt")).click();
//		}
////		j = 0;
////		while (j < 4)  {
////			dinnu.findElement(By.id("hrefIncChd")).click();
////			j++;
////		}
////		dinnu.findElement(By.id("hrefIncInf")).click();
//		
//		dinnu.findElement(By.id("btnclosepaxoption")).click();
//		System.out.println(dinnu.findElement(By.id("divpaxinfo")).getText());
//		
	}

}
