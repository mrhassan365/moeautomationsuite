package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.NewContactPage;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	NewContactPage newcontactPage;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super(); // keyword will call the constructor of the super class (in this case "TestBase"

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContactsLink();

	}

//	@Test(priority = 1)
//	public void verifyContactsPageLabelDisplays() {
//		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
//
//	}
//	
//	@Test(priority = 2)
//	public void verifyContactsLabelText() {
//		String text = contactsPage.verifyContactsLabelText();
//		Assert.assertEquals(text, "Contacts", "Contacts text is incorrect");
//	}
//
//	@Test(priority = 3)
//	public void selectContactsTest() {
//		contactsPage.selectContacts(2);
//	}
//	
//	@Test(priority = 4)
//	public void selectmultipleContactsTest() {
//		contactsPage.selectContacts(2);
//		contactsPage.selectContacts(1);
//		contactsPage.selectContacts(3);
//
//
//	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 1, dataProvider = "getCRMTestData")
	public void createContact(String first, String last, String comp) {
		contactsPage.toNewContactForm();
		contactsPage.createNewContact(first, last, comp);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
