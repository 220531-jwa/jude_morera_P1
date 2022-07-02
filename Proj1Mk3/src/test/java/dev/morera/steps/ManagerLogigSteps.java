package dev.morera.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.morera.pages.LogigPage;
import dev.morera.runners.LogigRunner;
import io.cucumber.java.en.*;

public class ManagerLogigSteps {

	private WebDriver driver = LogigRunner.driver;
	private LogigPage logigPage = LogigRunner.LogigPage;

	@Given("a Manager is on LogigPage")
	public void a_manager_is_on_logig_page() {

		driver.get("http://localhost:8081/logigPage.html");
	}

	@When("the employee types in their {string} and {string}")
	public void the_employee_types_in_their_and(String uname, String pword) {
		logigPage.unameInput.sendKeys("UnlimitedPower");
		logigPage.pwordInput.sendKeys("TheSenate");
	}

	@When("checks the managerCheckBox")
	public void checks_the_manager_check_box() {
		logigPage.managerCheckBox.click();
	}

	@When("hits login Button")
	public void hits_login_button() {
		   logigPage.loginButton.click();
	}

	@Then("the Manager should be on the Manager Page")
	public void the_manager_should_be_on_the_manager_page() {
		// Write code here that turns the phrase above into concrete actions
		new WebDriverWait(driver,Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Manager Login"));
		
		assertEquals("Manager Login", driver.getTitle());
	}

}
