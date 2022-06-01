package com.seleniumPractice;

//import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] productNames = { "Beans", "Cucumber", "Potato", "Walnuts" };

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*implicit wait it will wait for 5 seconds until the results are found 
		if results are found within 2seconds it will proceed to next step
		if it takes more than 5 seconds it will fail*/
		
		/*explict wait --- web driver wait
		 */
//		 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		addToCart(driver,productNames);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	public static void addToCart(WebDriver dinnu, String[] productNames) throws InterruptedException {
		Thread.sleep(1500);
		List<WebElement> products = dinnu.findElements(By.xpath("//h4[@class='product-name']"));
		int j = 0;
		for (int i = 0; i < products.size(); i++) { // iterating of products

			String[] name = products.get(i).getText().split("-");// into a string name and split
			String formantedName = name[0].trim();
			// convert array into array list for easy search
			// why converting array into array list, why can't we define initially, becoz
			// array takes less memory
			List<String> namesList = Arrays.asList(productNames);

			// check whether name you extracted is present in array or not

			if (namesList.contains(formantedName)) { // if that name contains Cucumber but arrayList check full string
														// matched or not
				j++;
				// dinnu.findElements(By.xpath("//button[text()='ADD TOCART']")).get(i).click(); 
				//here we are doing searching by text but when we click on add to cart to shows added and the index was changing
				
				
//				System.out.println(formantedName);
				Thread.sleep(1000);
				if(formantedName.equalsIgnoreCase("Cucumber")){
					dinnu.findElements(By.xpath("//div[@class='product'] //a[@class='increment']")).get(i).click();
					dinnu.findElements(By.xpath("//div[@class='product'] //a[@class='increment']")).get(i).click();
				}
					
				
				dinnu.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// findElemets it will get all the buttons in the page, but we mentioning the
				// get(i), the index cucumber having same equal to add to cart here
//				System.out.println("found It " + formantedName + " " + i);
				if (j == productNames.length)
					/*we use length() method
					 to get Size of Array
					  And we use size()
					method to get size of
					     ArrayLlst */
					// for one statement we don't need any flower brackets
					break; // here 4 number is how many number of items we needed to add to cart
			}
		}
	}

}
