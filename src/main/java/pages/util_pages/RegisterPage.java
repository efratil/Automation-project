package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenuPage;

public class RegisterPage extends MenuPage{

	public RegisterPage(MainPageManager pages) {
		super(pages);
	}
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	
	public RegisterPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(registerButton));
		return this;
	}
	
	
	public RegisterPage chooseGender(String gender) {
		log.info("Select Gender " + gender);
		if (gender.equals("male"))
			driver.findElement(By.id("gender-male")).click();
		else
			driver.findElement(By.id("gender-female")).click();
		return this;
	}

	
	public RegisterPage setFirstName(String firstName) {
		log.info("Fill your first name " + firstName);
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		return this;
	}
	
	
	public RegisterPage setLastName(String lastName) {
		log.info("Fill your last name " + lastName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		return this;
	}
	
	
	public RegisterPage setBirthDay(String day) {
		log.info("type birth day " + day);
		Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
		birthDay.selectByVisibleText(day);
		return this;
	}
	
	
	public RegisterPage setBirthMonth(String month) {
		log.info("type birth month " + month);
		Select birthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		birthMonth.selectByVisibleText(month);
		return this;
	}
	
	
	public RegisterPage setBirthYear(String year) {
		log.info("type birth year " + year);
		Select birthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
		birthYear.selectByVisibleText(year);
		return this;
	}
	
	public RegisterPage setEmail(String email) {
		log.info("Fill your email adress " + email);
		driver.findElement(By.id("Email")).sendKeys(email);
		return this;
	}
	
	public RegisterPage setPassword(String password) {
		log.info("Fill your password " + password);
		driver.findElement(By.id("Password")).sendKeys(password);
		return this;
	}
	
	public RegisterPage setConfirmPassword(String confirmPassword) {
		log.info("Fill your confirm password " + confirmPassword);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
		return this;
	}
	
	public RegisterSuccessPage clickRegisterButton() {
		 
		log.info("Click Register button ");
		driver.findElement(By.id("register-button")).click();
		
		return pages.registerSuccessPage.ensurePageLoaded();
	}
	


}
