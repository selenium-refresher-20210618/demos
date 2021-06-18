package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://127.0.0.1:8080");
		
		driver.findElement(By.id("first-button")).click();
		// dismiss alert that pops up when we click the first button
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("second-button")).click();
		
		WebDriverWait wdw1 = new WebDriverWait(driver, 5);
		
		String data1 = wdw1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p[1]"))).getText();
		System.out.println(data1);
		
		WebDriverWait wdw2 = new WebDriverWait(driver, 10);
		
		String data2 = wdw2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p[2]"))).getText();
		System.out.println(data2);
	}

}
