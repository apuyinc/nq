package nicequest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageModel {

	public WebDriver driver;
	public String defaultUrl;

	/** Types for web element references */
	public static enum ReferenceType {
		ID, XPATH, NAME, CLASS
	};

	public PageModel(WebDriver driver, String defaultUrl) {
		this.driver = driver;
		this.defaultUrl = defaultUrl;
	}

	public String getDefaultUrlPage() {
		return defaultUrl;
	}

	/**
	 * get an element from webpage either by Id or Xpath
	 * 
	 * @param elementReference
	 *            the name of the element
	 * @return the webElement
	 */
	protected WebElement getWebElement(String elementReference) {
		if (elementReference.contains("//"))
			return (driver.findElement(By.xpath(elementReference)));
		else
			return (driver.findElement(By.id(elementReference)));

	}

	/**
	 * get a WebElement from webpage based on name and type
	 * 
	 * @param elementReference
	 *            the string used to search the element in webpage
	 * @param type
	 *            the type of the elementReference
	 * @return the WebElement
	 */
	protected WebElement getWebElement(String elementReference,
			ReferenceType type) {

		switch (type) {
		case ID:
			return (driver.findElement(By.id(elementReference)));
		case NAME:
			return (driver.findElement(By.name(elementReference)));
		case XPATH:
			return (driver.findElement(By.xpath(elementReference)));
		case CLASS:
			return (driver.findElement(By.className(elementReference)));
		default:
			return (driver.findElement(By.id(elementReference)));

		}
	}

	/**
	 * Fill in with text a WebElement
	 * 
	 * @param elementReference
	 *            the identifier of the WebElement
	 * @param value
	 *            the value to fill in
	 */
	protected void typeInElement(String elementReference, String value) {

		if (value != null) {
			WebElement element = getWebElement(elementReference);
			element.clear();
			element.sendKeys(value);
		}
	}

	/**
	 * 
	 * @param referenceType
	 * @param elementReference
	 * @param value
	 */
	protected void typeInElement(ReferenceType referenceType,
			String elementReference, String value) {

		if (value != null) {
			WebElement element = getWebElement(elementReference, referenceType);
			element.clear();
			element.sendKeys(value);
		}
	}

	/**
	 * 
	 * @param elementReference
	 */
	protected void clickOnElement(String elementReference) {

		WebElement element = getWebElement(elementReference);
		element.click();
	}

	/**
	 * 
	 * @param elementReference
	 * @param type
	 */
	protected void clickOnElement(String elementReference, ReferenceType type) {
		WebElement element = getWebElement(elementReference, type);
		element.click();
	}

	/**
	 * 
	 * @param elementReference
	 * @return
	 */
	protected String getTextElement(String elementReference) {

		WebElement element = getWebElement(elementReference);
		return element.getText();
	}

	/**
	 * 
	 * @param elementReference
	 * @return
	 */
	protected String getValueElement(String elementReference) {

		WebElement element = this.getWebElement(elementReference);
		return (element.getAttribute("value"));
	}

	/**
	 * 
	 * @param text
	 * @param fieldElement
	 * @return
	 */
	public boolean verifyExistsTextInField(String text, String fieldElement) {

		String textField = this.getTextElement(fieldElement);
		if (textField.contains(text))
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param elementReference
	 * @return
	 */
	public boolean verifyElementIsPresent(String elementReference) {

		try {
			@SuppressWarnings("unused")
			WebElement element = this.getWebElement(elementReference);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param elementReference
	 * @return
	 */
	public boolean verifyElementIsVisible(String elementReference) {

		try {
			WebElement element = this.getWebElement(elementReference);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param elementReference
	 * @param type
	 * @return
	 */
	public boolean verifyElementIsVisible(String elementReference,
			ReferenceType type) {

		try {
			WebElement element = this.getWebElement(elementReference, type);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 
	 */
	public void waitPageLoaded() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);

	}

	/**
	 * This method should be improved to handle when the webpage has finished
	 * loading, either by checking readyState or by looking for a field within
	 * the page
	 * 
	 * @throws InterruptedException
	 */
	public void waitForPageLoaded() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
