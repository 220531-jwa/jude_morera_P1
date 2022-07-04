package dev.morera.runners;

import java.io.File;

import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.morera.pages.LogigPage;
import dev.morera.pages.RequestFormPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
@Suite
public class SeleniumTest {

	
	public static WebDriver driver;
	public static LogigPage LogigPage;
	public static RequestFormPage ReqForm;

	
	@BeforeAll
	public static void setup() {
		File firefox = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
		driver = new FirefoxDriver();
		
		LogigPage = new dev.morera.pages.LogigPage(driver);
		ReqForm = new dev.morera.pages.RequestFormPage(driver);
	}
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
		
		
		
		

	
		
	

}
