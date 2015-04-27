package nicequest.pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends PageModel {

	private final static String DEFAULT_URL = "";
	private final static String LOGIN_LINK = "login_link";
	private final static String LOGIN = "login";
	private final static String PASSWORD = "password";

	public MainPage(WebDriver driver) {

		super(driver, DEFAULT_URL);
	}

	public void clickOnLoginLink() {

		super.clickOnElement(LOGIN_LINK);
	}

	public void typeLogin(String login) {

		super.typeInElement(ReferenceType.NAME, LOGIN, login);
	}

	public void typePassword(String password) {
		super.typeInElement(ReferenceType.NAME, PASSWORD, password);
	}

	// an ID should be added instead of "orangebox"
	public void clickOnLogin() {
		super.clickOnElement("orangebox", ReferenceType.CLASS);
	}
}
