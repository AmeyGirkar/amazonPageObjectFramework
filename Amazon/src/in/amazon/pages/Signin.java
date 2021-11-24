package in.amazon.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signin {

	@FindBy(id="ap_email")
	private WebElement emailTextBox;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	@FindBy(xpath="//span[contains(@class,'a-list-item')]")
	private WebElement errMsg;
	
	public Signin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	public String getErrMsg() {
		String text = errMsg.getText();
		return text;
	}
	
	public void clearfield() {
		emailTextBox.clear();
		
	}
	
}
