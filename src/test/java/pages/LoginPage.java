package pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	public Actions action = new Actions(driver);

	// *********Constructor*********
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	By loginPageButton = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]");
	By login2 = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a");
	By usernameBy = By.id("L-UserNameField");
	By passwordBy = By.id("L-PasswordField");
	By loginButtonBy = By.id("gg-login-enter");
	By successLogin = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]/span");
	// *********Page Methods*********

	public LoginPage loginToGG(String username, String password) {
		writeText(usernameBy, username);
		writeText(passwordBy, password);
		click(loginButtonBy);
		return this;
	}

	public LoginPage verifyLogin(String expectedText) {
		assertEquals(successLogin, expectedText);
		return this;
	}

	public LoginPage clickLogin() {
		action.moveToElement(driver.findElement(loginPageButton)).perform();
		click(login2);
		return this;
	}

}