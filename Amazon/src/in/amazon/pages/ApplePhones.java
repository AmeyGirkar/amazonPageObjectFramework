package in.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplePhones {

	@FindBy (xpath = "(//div[contains (@class,'col-inner')]) [4]")
	private WebElement firstApplePhone;
	public ApplePhones (WebDriver driver) {
	PageFactory.initElements (driver, this);
	}
	public void clickFirstApplePhone() {
	firstApplePhone.click();
	}
}
