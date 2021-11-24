package in.amazon.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import in.amazon.pages.LandingPage;
import in.amazon.pages.Signin;
import utils.ReadExcel;

public class invaliduserTest {

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
	public void invalidUserShouldNotBeAbleToLogin() throws InterruptedException, IOException {
		// 4) Hover over 'Hello Sign in' menu
		LandingPage landingPage = new LandingPage(driver);
		landingPage.hoverOverHelloSignIn();

		// 5) Click on 'Sign in' button
		landingPage.clickSignInBtn();

		// 6) Enter an invalid username - 'batman554466@gmail.com'
		Signin signIn = new Signin(driver);
		
			
		signIn.enterUsername("batman554466@gmail.com");
		Thread.sleep(2000);

		// 7) Click on Continue button
		signIn.clickContinueBtn();

		// 8) Verify the error message - 'We cannot find an account with that email
		// address' is displayed.
		String expectedErrMsg = "We cannot find an account with that email address";
		String actualErrMsg = signIn.getErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
		
	}
	

//	9) Close the browser
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
