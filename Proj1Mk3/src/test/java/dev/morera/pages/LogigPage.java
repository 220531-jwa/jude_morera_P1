package dev.morera.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogigPage {
	
	private WebDriver driver;
	
	public LogigPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="uname")
	public WebElement unameInput;
	
	@FindBy(id = "pword")
	public WebElement pwordInput;
	
	@FindBy(id = "loginButton")
	public WebElement loginButton;
	
	@FindBy (id = "managerCheckBox")
	public WebElement managerCheckBox;
	
	
}
