package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		WebElement leftTable = driver.findElement(By.xpath("//div[@class='left-align'] //table"));
		
		//Print Number of rows
		List<WebElement> rows = leftTable.findElements(By.tagName("tr"));
		int numOfRows = rows.size();
		System.out.println("Number of Rows: "+numOfRows);
		
		//Print Number of Columns
		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		int numOfColumns = columns.size();
		System.out.println("Number of Columns: " + numOfColumns);
		
		//Print the text of Second Row
		List<WebElement> secondRow = rows.get(2).findElements(By.tagName("td"));
		for(int i=0;i<secondRow.size();i++) {
			System.out.print(secondRow.get(i).getText() + " -- ");
		}
		
	}

}
