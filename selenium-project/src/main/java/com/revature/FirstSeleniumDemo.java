package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// Manually specify the location of our WebDriver
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\BachTran\\Desktop\\6-18-2021-selenium-refresher\\selenium-project\\src\\main\\resources\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		
		// name locator method
//		WebElement inputBox = driver.findElement(By.name("q"));
		
		// CSS Selector method
//		WebElement inputBox = driver.findElement(By.cssSelector("input[name*='q']"));
		
		// XPath locator method
		WebElement inputBox = driver.findElement(By.xpath("//input[@name='q']"));
		inputBox.sendKeys("Hello World");
		
		Thread.sleep(7000);
		
		// Best practice, whenever you're done with utilizing Selenium is to use
		driver.quit(); // ensures that your browser window is closed and ChromeDriver or whatever WebDriver you're using is also closed
		
		// driver.close(); // just ensures that your browser window gets closed
	}

}
