package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		Actions clickOnSearchBarAndTypeCapitalA = new Actions(driver);
		clickOnSearchBarAndTypeCapitalA.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
			.click()
			.keyDown(Keys.LEFT_SHIFT)
			.sendKeys("apple")
			.keyUp(Keys.LEFT_SHIFT)
			.sendKeys(Keys.ENTER)
			.build()
			.perform();
	}

}
