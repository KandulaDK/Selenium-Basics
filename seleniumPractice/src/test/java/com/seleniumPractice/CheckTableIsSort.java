package com.seleniumPractice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckTableIsSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();

		dinnu.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on column
		// capture all webelements into list
		// capture text of all webelements into new(original)list
		// compare original list vs sorted list
		// sort on the original list of step3->sorted list.

		dinnu.findElement(By.xpath("//tr //th[1]")).click();

		List<WebElement> items = dinnu.findElements(By.xpath("//tr //td[1]"));

		List<Object> itemNames = items.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<Object> sortedItems = itemNames.stream().sorted().collect(Collectors.toList());

		// comparing orginal list vs sorted list
		Assert.assertTrue(itemNames.equals(sortedItems));

		// scan veg names column with getText() and if it match with the input "Beans"
		// veg name then the respective veg price should be displayed
		List<String> price;
		do {
			List<WebElement> row = dinnu.findElements(By.xpath("//tr //td[1]"));
			price = row.stream().filter(s -> s.getText().startsWith("C")).map(s -> getThePrice(s)).collect(Collectors.toList());

			if(price.size() < 1) {
				dinnu.findElement(By.cssSelector("a[aria-label$='Next']")).click();
			}else {
				List<WebElement> it = row.stream().filter(s -> s.getText().startsWith("C")).collect(Collectors.toList());

				for (int j = 0; j < price.size(); j++) {

					System.out.print(it.get(j).getText() + ": ");
					System.out.println(price.get(j));
				}
			}
		} while (price.size() < 1);

	}

	private static String getThePrice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
