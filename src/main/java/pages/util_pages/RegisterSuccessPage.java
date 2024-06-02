package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenuPage;

public class RegisterSuccessPage extends MenuPage{
	private final static String REGISTER_MESSAGE = "Your registration completed";

	public RegisterSuccessPage(MainPageManager pages) {
		super(pages);
	}
		
	public RegisterSuccessPage ensurePageLoaded() {
		super.ensurePageLoaded();
		//waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".register-continue-button"))));

		return this;
	}
	

	public RegisterSuccessPage verifyRegisterSuccessTextPage() {
		log.info("verify register success is" + " " + REGISTER_MESSAGE);
		String actualMessage = driver.findElement(By.cssSelector("div.result")).getText();
 
		Assert.assertTrue(actualMessage.equals(REGISTER_MESSAGE),
		"Expected value: '" + REGISTER_MESSAGE + "', but actual is '" + actualMessage + "'");
		return this;
	}
	
	public HomePage clickContinue() {
		log.info("Click Continue button");
		driver.findElement(By.cssSelector(".register-continue-button")).click();
		
		return pages.homePage.ensurePageLoaded();
	}
	
}
