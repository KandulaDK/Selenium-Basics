package Assignments;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_3 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
//		String userName = "rahulshettyacademy";
//		String password = "learning";

		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();

		// ImplicitylyWait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Url
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		loginPage(driver);
		
	
		
		//Add items to Cart and open the cart
		List<WebElement> addButtons = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		int totalItems = addButtons.size();
		System.out.println(totalItems);
		
		String str = Integer.toString(totalItems); //converted size of items to string
		
		for (WebElement addButton : addButtons) {
			addButton.click();
		}
		
		String actualSize = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).getText();
		
		if (actualSize.contains(str)) {
			System.out.println("Yes items and added are equal");
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	}

	public static void loginPage(WebDriver driver) throws InterruptedException {
		// getting userName and Password
		String userName = driver.findElement(By.xpath("(//i)[1]")).getText();
		String password = driver.findElement(By.xpath("(//i)[2]")).getText();

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text() = ' User']/following-sibling::span[@class='checkmark']")).click();
		
		WebDriverWait Expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Expwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		
		driver.findElement(By.id("okayBtn")).click();
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

	}
}
