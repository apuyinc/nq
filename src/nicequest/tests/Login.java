package nicequest.tests;

import static org.junit.Assert.*;
import nicequest.pages.MainPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Login {
	private WebDriver driver;
	private String baseUrl = "http://www.nicequest.com";
	private String urlLoggedIn = "https://www.nicequest.com/portal_nicequest/home.html";
	private String userName = "panelista.es@netquest.es";
	private String password = "passwford";
	private MainPage mainPage;

	@Before
	public void initTest() {
		driver = new ChromeDriver();
		mainPage = new MainPage(driver);
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
			assertTrue(driver.getCurrentUrl().equalsIgnoreCase(urlLoggedIn));
		} catch (Exception ex) {
			assertTrue(false);
		}
	}

	@After
	public void afterTest() {
		driver.close();
	}

}
