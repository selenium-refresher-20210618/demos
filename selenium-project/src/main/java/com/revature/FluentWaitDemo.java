package com.revature;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://127.0.0.1:8080");
		
		driver.findElement(By.id("first-button")).click();
		// dismiss alert that pops up when we click the first button
		driver.switchTo().alert().accept();
		
		// Fluent waits allow us to customize the polling duration, so that we can poll more or less than 500 milliseconds, which is
		// What an explicit wait does.
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(250))
				.ignoring(NoSuchElementException.class);
		
		WebElement firstParagraphTag = fluentWait.until((d) -> {
			// We can put in other custom logic here too
			System.out.println("Polling...");
			return d.findElement(By.xpath("//div/p[1]"));
		});
		
		System.out.println(firstParagraphTag.getText());
	}
	
}
