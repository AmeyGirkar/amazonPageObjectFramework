package in.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	private Actions actions;
	private WebDriverWait wait;

	// private WebElement mobiles = driver.findElement(By.linkText("Mobiles"));
	@FindBy(linkText = "Mobiles")
	private WebElement mobiles;
	
	@FindBy(id="nav-link-accountList")
	private WebElement helloSignInMenu;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInBtn;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver,10);
	}

	public void clickMobiles() {
		mobiles.click();
	}
	
	public void hoverOverHelloSignIn() {		
		actions.moveToElement(helloSignInMenu).build().perform();
	}
	
	public void clickSignInBtn() {		
		wait.until(ExpectedConditions.visibilityOf(signInBtn));
		signInBtn.click();
	}
}
