package tests;

import org.testng.annotations.Test;

import pages.BasketPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class LoginTests extends BaseTest {
	@Test(priority = 0)
	public void homePageTest() {

		// *************PAGE INSTANTIATIONS*************
		HomePage homePage = new HomePage(driver);

		// *************PAGE METHODS********************
		homePage.goToGG().verifyHomePage(driver.getTitle());
	}

	@Test(priority = 1)
	public void loginPageTest() {
		// *************PAGE INSTANTIATIONS*************
		LoginPage loginPage = new LoginPage(driver);
		// *************PAGE METHODS********************
		loginPage.clickLogin().loginToGG("beyza_maden97@hotmail.com", "B944457m.").verifyLogin("beyzamadenoglu916241");

	}

	@Test(priority = 2)
	public void searchPageTest() {
		// *************PAGE INSTANTIATIONS*************
		SearchPage searchPage = new SearchPage(driver);
		// *************PAGE METHODS********************
		searchPage.searchItem("Bilgisayar").clickSearch().goTo2ndPage().verify2ndPage();
	}

	@Test(priority = 3)
	public void basketPageTest() {
		// *************PAGE INSTANTIATIONS*************
		BasketPage basketpage = new BasketPage(driver);
		// *************PAGE METHODS********************
		basketpage.addRandomProduct().verifyPrice().increaseItem().increaseVerify().clearBasket().clearVerify();

	}
}