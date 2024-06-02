package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class OldCodeTest extends TestBase {

	@Test
	public void test() {
		try {

			WebDriver driver = app.getDriver();
			driver.get("https://demo.nopcommerce.com/");
			
			log.info("click log in link");
			driver.findElement(By.cssSelector(".ico-login")).click();
			
			
			log.info("Click Register link");
			driver.findElement(By.linkText("Register")).click();
			

			log.info("Select Gender");
			driver.findElement(By.id("gender-female")).click();
			

			log.info("Fill your first name");
			driver.findElement(By.id("FirstName")).sendKeys("Efrat");
			
			
			log.info("Fill your last name");
			driver.findElement(By.id("LastName")).sendKeys("Ilouz");
			
			
			log.info("type day '24");
			Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
			day.selectByVisibleText("24");
			
			
			log.info("type month 'April'");
			Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
			month.selectByVisibleText("April");
			
			log.info("type year '2000");
			Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
			year.selectByVisibleText("2000");
			
			
			log.info("Fill your Email");
			driver.findElement(By.id("Email")).sendKeys("sefhdafwesfz@gmail.com");
			
			
			log.info("Fill your Password");
			driver.findElement(By.id("Password")).sendKeys("ef1234");
			
			
			log.info("Confirm your Password");
			driver.findElement(By.id("ConfirmPassword")).sendKeys("ef1234");
			

			log.info("Click Register button");
			driver.findElement(By.id("register-button")).click();
			
			final String SUCCESS_MESSAGE = "Your registration completed";
			
			log.info("Verify message: " + SUCCESS_MESSAGE);
			
			String actualTextRegistration = 
			driver.findElement(By.cssSelector("div.result")).getText();
			
			Assert.assertTrue(actualTextRegistration.equals(SUCCESS_MESSAGE),
			"Expected value: '" + SUCCESS_MESSAGE + "', but actual is '" + 
			actualTextRegistration + "'");

			
			log.info("Click Continue button");
			driver.findElement(By.cssSelector(".register-continue-button")).click();

			final String BACK_TO_HOME_MESSAGE = "Welcome to our store";
			
			log.info("Verify message: " + BACK_TO_HOME_MESSAGE);
			
			String actualTextContinue = 
			driver.findElement(By.cssSelector("div.topic-block-title")).getText();
			
			Assert.assertTrue(actualTextContinue.equals(BACK_TO_HOME_MESSAGE),
			"Expected value: '" + BACK_TO_HOME_MESSAGE + "', but actual is '" + 
			actualTextContinue + "'");
			
			GenUtils.sleepMillis(2000);

			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
}
