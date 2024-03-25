package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePickerPage extends BasePage{
	
	public WebDriver driver;
	public DatePickerPage(WebDriver driver) {
		super(driver);
		
	}

	//locators
	
	@FindBy(xpath="//div[@class='MuiPickersDateRangePickerInput-root']//div[1]//div[1]//div[1]//input[1]") 
	WebElement  clickDatePicker;
	
	@FindBy(css="button[aria-label='Mar 27, 2024']")
	WebElement startDate;
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersArrowSwitcher-iconButton MuiIconButton-sizeSmall']//span[@class='MuiIconButton-label']//*[name()='svg']")
	WebElement nextSlide;
	
	@FindBy(css="button[aria-label='Apr 29, 2024']")
	WebElement endDate;
	
	@FindBy(css=".travel_main_cta")
	WebElement nextButton;


	//Actions
	
	public void setDate() throws InterruptedException {
		
		Thread.sleep(2000);
		clickDatePicker.click();
		startDate.click();
		
		nextSlide.click();
		endDate.click();
	}
	
	public void clickNext() {
		nextButton.click();
		
	}
	
	
	
}
