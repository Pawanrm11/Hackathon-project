package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsurancePage extends BasePage {
	
	public WebDriver driver;

	public CarInsurancePage(WebDriver driver) {
		super(driver);
	}
	//Locators 
	
	@FindBy(css=".btn-proceed") WebElement buyingANewCar;
	
	@FindBy(css="#spn6") WebElement chennai;
	
	@FindBy(xpath="//*[@id=\"section3\"]/ul/li[14]/span")WebElement rto;
	
	@FindBy(xpath="//*[@id=\"dvMake\"]/div/ul/div/li[8]/span") WebElement renault;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/div[1]/li[5]/span[1]") WebElement kwid;
	
	@FindBy(xpath="//b[normalize-space()='1.0 RXT (999 cc)']") WebElement variant;
	
	@FindBy(css="#name") WebElement fullName;
	
	@FindBy(css="#email") WebElement email;
	
	@FindBy(css="#mobileNo") WebElement mobileNo;
	
	@FindBy(css="button[id='btnLeadDetails'] span") WebElement viewPrices;
	
	@FindBy(css=".msg-error.show") WebElement errorMsg;
	
	//Actions 
	
	public void carNumber() {
		buyingANewCar.click();
	}
	
	public void rtoNumber() {
		chennai.click();
		rto.click();
	}
	
	public void carBrand() {
		renault.click();
	}
	public void carName() {
		kwid.click();
	}
	public void carVariant() {
		variant.click();
	}
	
	public void custName(String name) {
		fullName.sendKeys(name);
	}
	public void emailId(String id) {
		email.sendKeys(id);
	}
	public void mobileNumber(String num) {
		mobileNo.sendKeys(num);
	}
	public void clickViewprice() {
		viewPrices.click();
	}
	public void errorMessage() {
		System.out.println(errorMsg.getText());
		
	}

}
