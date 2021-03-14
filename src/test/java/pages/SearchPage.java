package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
	// *********Constructor*********
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	By searchBox = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
	By searchButton = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button");
	By pagination = By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a");

	// *********Page Methods*********
	public SearchPage searchItem(String item) {
		writeText(searchBox, item);
		return this;
	}

	public SearchPage clickSearch() {
		click(searchButton);
		return this;
	}

	public SearchPage goTo2ndPage() {
		JsExecute("window.scrollBy(0,40000)");
		click(pagination);
		return this;
	}

	public SearchPage verify2ndPage() {
		assertEquals("2", driver.getCurrentUrl().split("sf=")[1]);
		return this;
	}
}
