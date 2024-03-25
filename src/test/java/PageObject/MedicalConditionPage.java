package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedicalConditionPage extends BasePage {
	
	public WebDriver driver;
	

	
	public MedicalConditionPage(WebDriver driver) {
		super(driver);
		
	}
	
	//locators 
	
	@FindBy(css="#ped_no") WebElement status; 
	
	@FindBy(css=".travel_main_cta") WebElement nextbtn;
	
	//Actions 
	
	public void medicalCondition() {
		
		status.click();
	}
	
	public void clickNext() throws InterruptedException {
		
		nextbtn.click();
		Thread.sleep(2000);	
	}
	

}
