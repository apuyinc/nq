package nicequest.tests;

import static org.junit.Assert.*;
import nicequest.pages.HomePage;
import nicequest.pages.MainPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Logout {
	private WebDriver driver;
	private String baseUrl = "http://www.nicequest.com";
	private String urlLoggedOut = "https://www.nicequest.com/portal_nicequest/public/es/index.html";
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
			homePage.clickOnLogout();
			mainPage.waitForPageLoaded();
			assertTrue(driver.getCurrentUrl().equalsIgnoreCase(urlLoggedOut));
		} catch (Exception ex) {
			assertTrue(false);
		}
	}

	@After
	public void afterTest() {
		driver.close();
	}

}
