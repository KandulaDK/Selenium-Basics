package com.seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dates {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
		dinnu.get("https://www.path2usa.com/travel-companions");
//		https://www.path2usa.com/travel-companions
		dinnu.findElement(By.id("travel_date")).click();
		Thread.sleep(2000);
		dinnu.findElement(By.cssSelector("[class ='datepicker-days'] [class$='datepicker-switch']")).click();
		WebElement yearB = dinnu.findElement(By.cssSelector("[class ='datepicker-months'] [class$='datepicker-switch']"));
		
		for(int i=0;i<5;i++) {
			String y = yearB.getText();
			if(y.equalsIgnoreCase("2023")) {
				List<WebElement> months = dinnu.findElements(By.className("month"));
				int c = months.size();
				for(int j=0;j<c;j++) {
					String m = months.get(j).getText();
					if(m.contains("Aug")) {
						months.get(j).click();
						break;
					}
				}
				break;
			}else {
				dinnu.findElement(By.cssSelector("[class ='datepicker-months'] [class$='next']")).click();
			}
		}
		
		
		
		List<WebElement> days = dinnu.findElements(By.className("day"));
		int count = days.size();
		for(int i=0;i<count;i++) {
			String text = days.get(i).getText();
			if (text.contains("26")) {
				days.get(i).click();
				break; 
			}
		}
	}

}
