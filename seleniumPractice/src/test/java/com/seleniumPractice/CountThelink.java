package com.seleniumPractice;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CountThelink {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
		dinnu.manage().window().maximize();
		
		dinnu.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//count of all links in the page
		System.out.println(dinnu.findElements(By.tagName("a")).size());
		
		//count of link in the footer section
		WebElement footer = dinnu.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//count of footer column one links
		WebElement footerColumn1 = footer.findElement(By.xpath(" //table[@class='gf-t']/tbody/tr/td[1]/ul"));
		System.out.println(footerColumn1.findElements(By.tagName("a")).size());
		
		//click on each link in the column and check if the pages are opening
		for(int i=1; i<footerColumn1.findElements(By.tagName("a")).size();i++) {
		
			String ctrlEnter = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerColumn1.findElements(By.tagName("a")).get(i).sendKeys(ctrlEnter);	
		
		}//open all the links in diff tabs
		
		Set<String> allTabs = dinnu.getWindowHandles();
		Iterator<String> a = allTabs.iterator();
		
		while(a.hasNext()) {
			
			dinnu.switchTo().window(a.next());
			System.out.println(dinnu.getTitle());
		
		}//check if it has window open if open move to that window and print the title of the page
		

//		dinnu.close();
	}

}
