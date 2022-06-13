package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class notAssignment {
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/");
		openPractice();
		driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//		w.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Practice")));
		
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		String radio = driver.findElement(By.xpath("//input[@value='radio2']")).getAttribute("value");
		
	}
	
	public static void openPractice() throws InterruptedException {

		driver.findElement(By.linkText("Practice")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Dinesh kumar");
		driver.findElement(By.id("email")).sendKeys("dineshkandula007@gmail.com");
		driver.findElement(By.id("agreeTerms")).click();
		driver.findElement(By.id("form-submit")).click();
		driver.findElement(By.linkText("Automation Practise - 2")).click();
	}
}
