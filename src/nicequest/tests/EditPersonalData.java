package nicequest.tests;

import static org.junit.Assert.*;
import nicequest.pages.HomePage;
import nicequest.pages.MainPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class EditPersonalData {
	private WebDriver driver;
	private String baseUrl = "http://www.nicequest.com";
	private String dataSavedOK = "/html/body/div/div[@id='content-layout']/div[@id='content']/div[@class='centered relative']/div[@id='main_content']/div[@class='personal_data']/form/div[@class='mensaje']/p[@class='success']";
	private String userName = "panelista.es@netquest.es";
	private String password = "password";
	private MainPage mainPage;
	private HomePage homePage;

	@Before
	public void initTest() {
		driver = new ChromeDriver();
		mainPage = new MainPage(driver);
		homePage = new HomePage(driver);

		driver.get(baseUrl);
	}

	@Test
	public void test() {
		try {
			mainPage.clickOnLoginLink();
			mainPage.typeLogin(userName);
			mainPage.typePassword(password);
			mainPage.clickOnLogin();

			mainPage.waitForPageLoaded();

			homePage.clickOnMyAccount();
			
			homePage.clickOnEdit();

			homePage.typeInNombre("test1");
			homePage.typeInSurname1("test2");
			homePage.typeInSurname2("test3");
			homePage.typeInAddress("BCN");
			
			homePage.clickOnSaveAddress();

			homePage.waitForPageLoaded();

		} catch (InterruptedException e) {
			assertTrue(false);
		}

		assertTrue(homePage.addressSavedSuccessfully());
	}

	@After
	public void afterTest() {
		driver.close();
	}

}
