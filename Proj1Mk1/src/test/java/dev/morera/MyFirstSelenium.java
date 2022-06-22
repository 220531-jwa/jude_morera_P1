package dev.morera;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		File firefox = new File("src/test/resources/geckodriver.exe");
		
		System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		
		searchBar.sendKeys("en passant" + Keys.ENTER);
		
		Thread.sleep(1000); //sleep for 1 second; BAD PRACTICE FOR ME 'OOMIES EYES 
		driver.quit();
		
		
		
		
		
	}

}
