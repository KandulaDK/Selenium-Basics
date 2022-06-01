package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_8 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		
		List<WebElement> c = driver.findElements(By.xpath("//ul[@id='ui-id-1'] //div[@class='ui-menu-item-wrapper']"));

		for(int i=0;i<c.size();i++) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			if(driver.findElement(By.id("autocomplete")).getAttribute("value").contains("USA")) {
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
				break;
			}
		}
			

		
//		List<WebElement> c = driver.findElements(By.xpath("//ul[@id='ui-id-1'] //div[@class='ui-menu-item-wrapper']"));
//		c.size();
//		for(int i=0;i<c.size();i++) {
//			String text = c.get(i).getText();
//			if(text.contains("USA")) {
//				c.get(i).click();
//				String result = driver.findElement(By.id("autocomplete")).getAttribute("value");
//				System.out.println(result); //United States (USA)
//				break;
//			}
//		}
		
	}

}
