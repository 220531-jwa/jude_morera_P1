package dev.morera.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;

import dev.morera.pages.LogigPage;
import dev.morera.runners.LogigRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import io.cucumber.java.en.*;

public class LogigSteps {

	private WebDriver driver = LogigRunner.driver;
	private LogigPage logigPage = LogigRunner.LogigPage;
	
	
	
	
	
	
	@Tag("Cuc")
	@Given("a Employee is on LogigPage")
	public void a_employee_is_on_logig_page() {
	    
	    driver.get("http://localhost:8081/logigPage.html");
	}

	@When("the Employee types in their {string} and {string} and clicks the loginButton")
	public void the_employee_types_in_their_and_and_clicks_the_login_button(String uname, String pword) {
	    
	   logigPage.unameInput.sendKeys(uname);
	   logigPage.pwordInput.sendKeys(pword);
	   logigPage.loginButton.click();
	}

	@Then("the Employee should be on the HomePage")
	public void the_employee_should_be_on_the_home_page() {
	   
		new WebDriverWait(driver,Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Employee Homepage"));
		
		assertEquals("Employee Homepage", driver.getTitle());
		
	    
	}
	
	
	
	
	
}
