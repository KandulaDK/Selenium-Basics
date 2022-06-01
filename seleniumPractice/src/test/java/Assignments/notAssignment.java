package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class notAssignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Tom");
		
		Thread.sleep(2000);
		String prodcutName = driver.findElement(By.cssSelector("h4[class='product-name']")).getText();
//		boolean b = driver.findElement(By.cssSelector("input[class='quantity']")).getAttribute("value").contains("3");
		while(!driver.findElement(By.cssSelector("input[class='quantity']")).getAttribute("value").contains("3")){
//			System.out.println(b);
			driver.findElement(By.cssSelector("a.increment")).click();
		}
		driver.findElement(By.xpath("//button[.='ADD TO CART']")).click();
		driver.findElement(By.cssSelector("[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']")).click();
		Thread.sleep(2000);
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("td p[class='product-name']")).getText(), prodcutName);
		Assert.assertEquals(driver.findElement(By.cssSelector("td p[class='quantity']")).getText(), "3");
		System.out.println(driver.findElement(By.cssSelector("button[class='promoBtn']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//button[.='Place Order']")).isEnabled());
	}
}
