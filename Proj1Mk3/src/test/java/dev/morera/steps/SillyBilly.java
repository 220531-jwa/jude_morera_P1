package dev.morera.steps;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.morera.pages.LogigPage;
import dev.morera.pages.RequestFormPage;
import dev.morera.runners.SeleniumTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SillyBilly {

	private WebDriver driver = SeleniumTest.driver;
	private LogigPage logigPage = SeleniumTest.LogigPage;
	private RequestFormPage ReqForm = SeleniumTest.ReqForm;
	
	@Given("User has logged in sucesfully")
	public void user_has_logged_in_sucesfully() {
		driver.get("http://localhost:8081/logigPage.html");
	
		 logigPage.unameInput.sendKeys("Hello");
		   logigPage.pwordInput.sendKeys("There");
		   logigPage.loginButton.click();
		
		   new WebDriverWait(driver,Duration.ofSeconds(10))
			.until(ExpectedConditions.titleContains("Employee Homepage"));
		
	}

	@When("click the drop down")
	public void click_the_drop_down() {
	    WebElement linky = driver.findElement(By.linkText("New"));
	    linky.click();
		
		
	}

	@Then("select from dropdown")
	public void select_from_dropdown() {
		
		new WebDriverWait(driver,Duration.ofSeconds(5))
		.until(ExpectedConditions.elementToBeClickable(ReqForm.typeSel));
		
		Select stuff = new Select(ReqForm.typeSel);
		stuff.selectByIndex(2);

		assertEquals(stuff.getAllSelectedOptions(), "Certification Prep. Class");
	}
	
	
	
	
}
