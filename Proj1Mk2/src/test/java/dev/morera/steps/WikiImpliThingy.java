package dev.morera.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import dev.morera.pages.WikiPage;
import dev.morera.runner.WikiRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WikiImpliThingy {

	private static WebDriver driver = WikiRunner.driver;
	private static WikiPage wikiPage = WikiRunner.wikiPage;

	/*	The following was auto-genned by running the .feature
	 * 
	 */

	@Given("user is on wikipedia home page")
	public void user_is_on_wikipedia_home_page() {
		driver.get("https://www.wikipedia.org");
		
	}

	@When("the user clicks on English link")
	public void the_user_clicks_on_english_link() {
		wikiPage.englishLink.click(); //because we set this up!
		
	}

	@Then("the title of the web page should be Wikipedia, the free encyclopedia")
	public void the_title_of_the_web_page_should_be_wikipedia_the_free_encyclopedia() {
		assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());
		
	}

}
