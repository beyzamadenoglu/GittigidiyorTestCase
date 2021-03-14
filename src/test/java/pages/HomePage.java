package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	// *********Constructor*********
	public HomePage(WebDriver driver) {
		super(driver);
	}

	String baseURL = "https://www.gittigidiyor.com/";
	// *********Page Methods*********
	public HomePage goToGG() {
		driver.get(baseURL);
		return this;
	}

	public HomePage verifyHomePage(String expectedText) {
		assertEquals("GittiGidiyor - T�rkiye'nin �nc� Al��veri� Sitesi", expectedText);
		return this;
	}

}
