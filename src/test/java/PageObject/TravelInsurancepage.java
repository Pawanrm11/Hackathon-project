package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelInsurancepage extends BasePage {
	

	public WebDriver driver;

	public TravelInsurancepage(WebDriver driver) {
		super(driver);
	
	}
	
	//Locators 
	
	@FindBy(css="img[src='https://static.pbcdn.in/travel-cdn/images/country/Germany.jpg']") WebElement germany;
	
	@FindBy(css="img[src='https://static.pbcdn.in/travel-cdn/images/country/USA.jpg']") WebElement uSA;
	
	//@FindBy(css=".travel_main_cta") WebElement nextBtn;
	
	@FindBy(xpath="//div[@class=\"pqCtaWrapper\"]//button") WebElement nextBtn;
	//actions 
	
	public void setGermany() {
		germany.click();
	}
	
	public void setUSA() {
		uSA.click();
	}
	
	public void clickNext() {
		nextBtn.click();
		/*JavascriptExecutor jse  =(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",nextBtn);*/
		
	}
}
