package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory or Object repository

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[@id='ui']/div/div/form/div/div[3]")
	WebElement login;

	@FindBy(xpath = "//a[@href='https://register.cogmento.com/password/reset/request/']")
	WebElement forgotPass;

	@FindBy(xpath = "//a[@href='https://api.cogmento.com/register']")
	WebElement signup;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this); // initilize the current class objects with the driver
	}

	// Actions:
	public String validateLoginPageTitile() {
		return driver.getTitle();
	}

	public HomePage login(String Email, String pass) {
		email.sendKeys(Email);
		password.sendKeys(pass);
		login.click();

		return new HomePage();

	}

}
