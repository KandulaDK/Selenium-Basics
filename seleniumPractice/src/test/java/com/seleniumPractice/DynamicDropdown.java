package com.seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		dinnu.get("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");

		dinnu.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1500);
		dinnu.findElement(By.xpath("//a[@value='HYD']")).click(); //regular xpath

//		dinnu.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click(); //id
		Thread.sleep(1000);
//		dinnu.findElement(By.xpath("(//a[@value='TRV'])[2]")).click(); //xpath using index
		dinnu.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='STV']")).click();//it will search child only in that parent
		dinnu.findElement(By.xpath("(//div[@id='ui-datepicker-div'] //a[@class='ui-state-default'])[1]")).click();

		updatedDrop(dinnu);
		SelectDropdown staticDropDown = new SelectDropdown();
		staticDropDown.staticDrop(dinnu);
		dinnu.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

	public static void updatedDrop(WebDriver dinnu) throws InterruptedException {
		dinnu.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1500);
		for (int i = 1; i < 5; i++) {
			dinnu.findElement(By.id("hrefIncAdt")).click();
		}
		int j = 0;
		while (j < 4) {
			dinnu.findElement(By.id("hrefIncChd")).click();
			j++;
		}
		dinnu.findElement(By.id("hrefIncInf")).click();

		dinnu.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(dinnu.findElement(By.id("divpaxinfo")).getText());
	}

}
