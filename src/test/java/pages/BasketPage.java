package pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {
	// *********Constructor*********
	Random random = new Random();
	List<WebElement> listOfElements;
	String randomProduct, itemNumberId = "id";
	int pick;
	String price, itemNumber, productPrice, increaseVerify;
	WebElement randomProductElement, randomProductElementChild;

	public BasketPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	By productTable = By.className("cell-border-css");
	By priceClass = By.className("fiyat");
	By deleteItem = By.className("btn-delete");
	By basketButton = By.className("dIB");
	// *********Page Methods*********
	public BasketPage addRandomProduct() {
		listOfElements = findAll(productTable);
		pick = random.nextInt(listOfElements.size());
		randomProduct = listOfElements.get(pick).getAttribute(itemNumberId).split("-")[3];
		price = listOfElements.get(pick).findElement(By.className("fiyat")).getText();
		return this;
	}

	public BasketPage verifyPrice() {
		JsExecute(String.format(
				"document.querySelector(\"#item-info-block-%s > div > div.gg-w-24.gg-d-24.gg-t-24.gg-m-24.pl0.pr0.product-info-details > div.gg-w-24.gg-d-24.gg-t-24.hidden-m.hidden-t.padding-none.buy-now-button > button\").click();",
				randomProduct));
		find(basketButton).click();
		randomProductElement = driver
				.findElement(By.cssSelector(String.format("div[data-product=\"%s-0\"]", randomProduct)));
		itemNumber = randomProductElement.getAttribute(itemNumberId).split("-")[2];
		productPrice = randomProductElement.findElement(By.className("total-price")).getText();
		assertEquals(price, productPrice);
		return this;

	}

	public BasketPage increaseItem() {
		randomProductElement
				.findElement(By.xpath(String
						.format("//*[@id=\"cart-item-%s\"]/div[2]/div[4]/div/div[2]/select/option[2]", itemNumber)))
				.click();
		;
		return this;
	}

	public BasketPage increaseVerify() {
		increaseVerify = randomProductElement
				.findElement(By
						.xpath(String.format("//*[@id=\"cart-item-%s\"]/div[2]/div[4]/div/div[2]/select", itemNumber)))
				.getAttribute("data-value");
		assertEquals(increaseVerify, "2");
		return this;
	}

	public BasketPage clearBasket() {
		randomProductElement.findElement(deleteItem).click();
		return this;
	}

	public BasketPage clearVerify() {
		try {
			find(By.cssSelector(String.format("div[data-product=\"%s-0\"]", randomProduct)));
		} catch (NoSuchElementException e) {
			System.out.println("Ürün Kaldýrýldý.");
		}
		return this;
	}
}
