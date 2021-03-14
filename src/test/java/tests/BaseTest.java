package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	final static Logger logger = Logger.getLogger(BaseTest.class);
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		logger.info("Test started.");
		setProperty();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		logger.info("Test ended.");
		// driver.quit();
		System.out.print("exit");
	}

	public static void setProperty() {
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
	}

}
