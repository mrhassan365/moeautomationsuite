package com.crm.qa.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends TestBase {

	HttpURLConnection connection;
	URL url;
	int status_code;

	@FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/span[1]")
	@CacheLookup // holds the webelemtns in a cache memeory so you don't have to keep hitting the
					// browser
	WebElement userNameLabel;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[*]")
	List<WebElement> navLinks;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]/span")
	WebElement contactsLink;

	@FindBy(xpath = "	//*[@id=\"main-nav\"]/a[5]span")
	WebElement dealsLink;

	@FindBy(xpath = "	//*[//*[@id=\"main-nav\"]/a[6]/span")
	WebElement taskLink;

	// initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();

	}

	public String verifyUserNameText() {
		return userNameLabel.getText();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealPage clickOnDealLink() {
		dealsLink.click();
		return new DealPage();
	}

	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();
	}

	public void verifyNavSize() {
		System.out.println(navLinks.size());
	}

	public void verifyNavURLTexts() {
		for (int i = 0; i < navLinks.size(); i++) {
			System.out.println(navLinks.get(i).getAttribute("href"));

		}

	}

	public void getHTTPStatusCode() throws IOException {

		for (WebElement l : navLinks) {

			String href = l.getAttribute("href");

			url = new URL(href);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int statuscode = connection.getResponseCode();
			System.out.println(statuscode);
		}

	}

}
