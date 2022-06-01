package com.seleniumPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();

//------------------"https://chromedriver.chromium.org/capabilities"---------		
		//set proxy	
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("myhttpproxy:portNumber");
		options.setCapability("proxy", proxy);
		
		//blocking popup's
		options.setExperimentalOption("excludeSwitches",
		Arrays.asList("disable-popup-blocking"));
		
		//changing default download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		//accept insecure certificates
		options.setAcceptInsecureCerts(true);
		//other browser options
//		EdgeOptions options1 = new EdgeOptions();
//		FirefoxOptions options2 = new FirefoxOptions();
//		SafariOptions options3 = new SafariOptions();
		
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver(options);

		dinnu.get("https://expired.badssl.com/");
		System.out.println(dinnu.getTitle());
		
		

	}

}
