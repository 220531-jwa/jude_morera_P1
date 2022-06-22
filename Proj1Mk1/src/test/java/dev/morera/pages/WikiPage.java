package dev.morera.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {
	
	//represents the page we'll be automating
	//Page Object Model (not to be confused with POM.xml (project object model))
	
	
	//need instance of driver 'ere
	private WebDriver driver;
	
	//con. to make instance of page and init. web elements
	public WikiPage(WebDriver driver) {
		this.driver = driver;
		
		//from pagefactory
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "js-link-box-en")
	public WebElement englishLink;
	
	//relative xpath starts with //*[@ blahblahbl ]
	// TO GET RELATIVE IN FIREFOX:
	// if it has no id, copy xpath
	//if it DOES, delete id first
	@FindBy(xpath ="/html/body/div[2]/div[5]" ) //this absolute,
	// relatives are normally better
	
	public WebElement germanLink;
	
	
	

}
