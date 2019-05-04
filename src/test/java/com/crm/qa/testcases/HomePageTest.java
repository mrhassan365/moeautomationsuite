package com.crm.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	static HomePage homePage;
	ContactsPage contactsPage;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[*]")
	static List<WebElement> navLink;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitletest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRM", "Homepage title not matched");

	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());

	}

	@Test(priority = 3)
	public void verifyUserNameTextTest() {
		String usernameText = homePage.verifyUserNameText();
		Assert.assertEquals(usernameText, "Mohammed Hassan", "User Name text isn't matched");

	}

	@Test(priority = 4)
	public void verifyContactsLinkclick() {
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 5)
	public void verifyNavLinksSize() {
		homePage.verifyNavSize();
	}

	@Test(priority = 6)
	public void verifyNavLinksTexts() {
		homePage.verifyNavURLTexts();
	}

	@Test(priority = 7)
	public static void statuscode() throws IOException {

		homePage.getHTTPStatusCode();
		

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}