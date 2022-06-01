package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		
		String grabbedLabel = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
		
		
		WebElement selectDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(selectDropdown);
		s.selectByValue(grabbedLabel);
		
		driver.findElement(By.id("name")).sendKeys(grabbedLabel);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		String output = driver.switchTo().alert().getText();
		if (output.contains(grabbedLabel)) {
			driver.switchTo().alert().accept();
			System.out.println("Successfully completed the Assignment");	
			Assert.assertTrue(true);
			System.out.println("OK");
		}else {
			System.out.println("Something went wrong");
			Assert.assertFalse(false);
		}
	}
}
