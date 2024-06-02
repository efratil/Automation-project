package pages.super_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.util_pages.HomePage;
import pages.util_pages.RegisterPage;
import pages.util_pages.RegisterSuccessPage;


public class MenuPage extends AnyPage{

	public MenuPage(MainPageManager pages) {
		super(pages);
	}
	
	public MenuPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
		return this;
	}
	
	public RegisterPage clickRegisterLink() {
		 
		log.info("Click Register link");
		driver.findElement(By.linkText("Register")).click();
		
		return pages.registerPage.ensurePageLoaded();
	}
		

	public HomePage logout() {
		log.info("Click logout button");
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		
		return pages.homePage.ensurePageLoaded();
	}
	
 
}
