package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class PageObjectCode extends TestBase {

		String timestamp, email, password;
		
	@Test
	public void test(   ) {
		try {
			
			initParameter();
			
			WebDriver driver = app.getDriver();
			driver.get("https://demo.nopcommerce.com/");
				
			app.pages().menuPage
			.clickRegisterLink()
			.chooseGender("female")
			.setFirstName("Efrat")
			.setLastName("Ilouz")
			.setBirthDay("24")
			.setBirthMonth("April")
			.setBirthYear("2000")
			.setEmail("errfgerf@gmail.com")
			.setPassword("ef1234")
			.setConfirmPassword("ef1234")
			.clickRegisterButton()
			.clickContinue()
			 .logout().verifyWelcomeText();
			
				endTestSuccess();
			} catch (Throwable t) {
				onTestFailure(t);
			}
		}
	private void initParameter() {
		timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
		email = "rfhrerf" + "timestamp" + "@gmail.com";
		password = "ef1234";
	}


}
