package driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static Logger log = LogManager.getLogger(Driver.class.getName());
	public static WebDriver driver;
	private String proPath = "src/main/java/driver/parameters.properties";
	public static Properties prop;
	public static FileInputStream fis;
	private static String brow;

	public WebDriver getAutomationProperties() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(proPath);

		if (fis == null) {
			log.error("Test Execution failed as unable to read property file");
		} else {
			log.info("Test Exection started with property file " + proPath);
			prop.load(fis);
			brow = prop.getProperty("browser");
			System.out.println(brow);
			if (brow.equalsIgnoreCase("Chrome")) {
				chromeDriver();
			} else if (brow.equalsIgnoreCase("Firefox")) {
				firefoxDriver();
			}
		}
		return driver;

	}

	@SuppressWarnings("deprecation")
	private void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	private void firefoxDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
