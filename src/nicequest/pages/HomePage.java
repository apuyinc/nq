package nicequest.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageModel {

	private static final String DEFAULT_URL = "/home.html";
	private static final String LOGOUT_LINK = "a-logout-btn";
	private static final String PROFILE_LINK = "profile-btn";
	private static final String NAME = "name";
	private static final String SURNAME1 = "surname1";
	private static final String SURNAME2 = "surname2";
	private static final String ADDRESS = "addresseeAddress";
	private static final String SAVE_BUTTON = "/html/body/div/div[@id='content-layout']/div[@id='content']/div[@class='centered relative']/div[@id='main_content']/div[@class='personal_data']/form/button[@class='bluebox mob-expand']";
	private static final String EDIT_BUTTON = "/html/body/div/div[@id='content-layout']/div[@id='content']/div[@class='centered relative']/div[@id='main_content']/div[@class='personal_data']/div[@class='box']/a[@class='bluebox mob-expand']";
	private static final String PERSONAL_DATA_SAVED_OK = "/html/body/div/div[@id='content-layout']/div[@id='content']/div[@class='centered relative']/div[@id='main_content']/div[@class='personal_data']/form/div[@class='mensaje']/p[@class='success']";

	public HomePage(WebDriver driver) {

		super(driver, DEFAULT_URL);
	}

	public void clickOnLogout() {

		super.clickOnElement(LOGOUT_LINK);
	}

	public void clickOnMyAccount() {
		super.clickOnElement(PROFILE_LINK, ReferenceType.CLASS);
	}

	public void clickOnEdit() {
		super.clickOnElement(EDIT_BUTTON, ReferenceType.XPATH);
	}

	public void typeInNombre(String value) {
		super.typeInElement(ReferenceType.NAME, NAME, value);
	}

	public void typeInSurname1(String value) {
		super.typeInElement(ReferenceType.NAME, SURNAME1, value);
	}

	public void typeInSurname2(String value) {
		super.typeInElement(ReferenceType.NAME, SURNAME2, value);
	}

	public void typeInAddress(String value) {
		super.typeInElement(ReferenceType.NAME, ADDRESS, value);
	}

	public void clickOnSaveAddress() {
		super.clickOnElement(SAVE_BUTTON, ReferenceType.XPATH);
	}

	public boolean addressSavedSuccessfully() {
		return super.verifyElementIsVisible(PERSONAL_DATA_SAVED_OK,
				ReferenceType.XPATH);
	}

}
