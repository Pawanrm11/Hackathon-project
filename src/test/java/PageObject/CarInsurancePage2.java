package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsurancePage2 extends BasePage {

	public WebDriver driver;

	public CarInsurancePage2(WebDriver driver) {
		super(driver);

	}

	// locators
	

	@FindBy(css = ".CarRegDetails_blueTextButton__P1blP.blueTextButton.fontMedium")
	WebElement clickHere;

	@FindBy(xpath="//span[normalize-space()='Chennai']") 
	WebElement chennai;

	@FindBy(xpath="//li[normalize-space()='TN18']") 
	WebElement tN18;

	@FindBy(css = "li[class='renault '] span[class='brandName']")
	WebElement renault;

	@FindBy(xpath="//li[normalize-space()='Kwid']")
	WebElement kwid;

	@FindBy(xpath="//li[normalize-space()='Petrol']")
	WebElement petrol;
	
	@FindBy(xpath="//li[contains(text(),'1.0 RXT (999 cc)')]")
	WebElement variant;

	@FindBy(css = "input[placeholder='Full name']")
	WebElement fullName;

	@FindBy(css = "input[placeholder='Your email']")
	WebElement yourEmail;

	@FindBy(css = "input[placeholder='Mobile number']")
	WebElement mobileNumber;

	@FindBy(css = "button[type='button']")
	WebElement viewPrices;

	@FindBy(css = ".errorMsg")
	WebElement errorMessage;
	// Actions

	public void carInsurance() {
		clickHere.click();
		chennai.click();
		tN18.click();
		renault.click();
		kwid.click();
		petrol.click();
		variant.click();

	}

	public void fillDetails(String name, String mobile, String email) {
		fullName.sendKeys(name);
		yourEmail.sendKeys(email);
		mobileNumber.sendKeys(mobile);

	}

	public void errorMsg() {
		System.out.println(errorMessage.getText());
	}

}
