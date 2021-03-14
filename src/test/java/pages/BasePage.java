package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import tests.BaseTest;

public class BasePage {
	final static Logger logger = Logger.getLogger(BaseTest.class);
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		logger.info("Page to Test : " + driver.getTitle());
		wait = new WebDriverWait(driver, 5);
	}

	// Wait Wrapper Method
	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	// Click Method
	public void click(By elementBy) {
		logger.info("Element Clicked : " + elementBy);
		waitVisibility(elementBy);
		driver.findElement(elementBy).click();
	}

	// Write Text
	public void writeText(By elementBy, String text) {
		logger.info("Element Writed: " + elementBy);
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
	}

	// Read Text
	public String readText(By elementBy) {
		logger.info("Element Read: " + elementBy);
		return driver.findElement(elementBy).getText();
	}

	// Assert String
	public void assertEquals(String elementText, String expectedText) {
		logger.info("Assert String: " + elementText);
		logger.info("Assert String: " + expectedText);
		Assert.assertEquals(elementText, expectedText);

	}

	// Assert WebElement
	public void assertEquals(By elementBy, String expectedText) {
		logger.info("Assert Element: " + elementBy);
		logger.info("Assert String: " + expectedText);
		Assert.assertTrue(readText(elementBy).equals(expectedText));

	}

	// JavaScript Execute
	public Object JsExecute(String Command) {
		logger.info("Execute Script: " + Command);
		js = (JavascriptExecutor) driver;
		return js.executeScript(Command);
	}

	public List<WebElement> findAll(By elementBy) {
		return driver.findElements(elementBy);
	}

	public WebElement find(By elementBy) {
		return driver.findElement(elementBy);
	}
}
