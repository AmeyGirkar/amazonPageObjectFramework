package in.amazon.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import in.amazon.pages.*;

public class BuyMobilePhoneTest {

	WebDriver driver;

	@BeforeTest

	public void launchApplication() {
		// 1) Open the browser
		driver = new ChromeDriver();
		// 2) Maximize it
		driver.manage().window().maximize();
		// 3) Navigate to application
		driver.get("https://amazon.in");
	}

	@Test
		public void buyMobile() {
		// 4) Click on 'Mobiles
		LandingPage landingPage = new LandingPage (driver);
		landingPage.clickMobiles();
		
		
		// 5) Hover over 'Mobiles & Accessories
		Mobiles mobiles = new Mobiles (driver);
		mobiles. hoverOverMobilesAndAccessories();
		// 6) Click on Apple' in the sub-menu
		mobiles.clickApple();
		
		
		// 7) Select first available phone
		ApplePhones applePhones = new ApplePhones (driver);
		applePhones.clickFirstApplePhone();
		// 8) Click on 'Buy Now' button
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		BuyPhone buyPhone = new BuyPhone(driver);
		buyPhone.clickBuyNowButton();
		// 9) Verify the user is on 'Sign-In' page
		String expectedTitle = "Amazon Sign In";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		}

	// 10) Close the browser
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}


