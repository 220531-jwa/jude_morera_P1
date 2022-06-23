package dev.morera.runner;

import java.io.File;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.morera.pages.WikiPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//glue code is concrete logic to allow the test to execute selenium based off feature
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"dev/morera/steps/WikiImpliThingy.java"})
public class WikiRunner {
	//need driver and instance of WikiPage POM
	public static WebDriver driver;
	public static WikiPage wikiPage;
	
	@BeforeAll
	public static void setup() {
		File firefox = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
		driver = new FirefoxDriver();
		
//		File chrome = new File("src/test/resources/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
//		driver = new ChromeDriver();
				
		
		
		wikiPage = new WikiPage(driver);
	}
	
	
	
	@AfterAll
	public static void teardown() {
		
		driver.quit();
	}
	
}
