package com.revature;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Configuring an implicit wait
		// Any searches for a WebElement after this line of code will wait up to a maximum of 5 seconds for that element to appear
		// before "giving up" (throwing a NoSuchElementException)
		
		driver.get("http://127.0.0.1:8080");

		driver.findElement(By.id("first-button")).click();
		String data1 = driver.findElement(By.xpath("//div/p[1]")).getText();
		
		driver.findElement(By.id("second-button")).click();
		String data2 = driver.findElement(By.xpath("//div/p[2]")).getText();
		
		System.out.println(data1);
		System.out.println(data2);
	}
	
}
