package PageObject;

import java.time.LocalDate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BaseClass;

public class DatePickerPage extends BasePage{
	
	public WebDriver driver;
	public DatePickerPage(WebDriver driver) {
		super(driver);
		
	}

	//locators
	
	@FindBy(xpath="//div[@class='MuiPickersDateRangePickerInput-root']//div[1]//div[1]//div[1]//input[1]") WebElement  clickDatePicker;
	@FindBy(css="button[aria-label='Mar 5, 2024']") WebElement startDate;
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersArrowSwitcher-iconButton MuiIconButton-sizeSmall']//span[@class='MuiIconButton-label']//*[name()='svg']")WebElement nextSlide;
	@FindBy(css="button[aria-label='Apr 29, 2024']") WebElement endDate;
	@FindBy(css=".travel_main_cta") WebElement nextButton;


	//Actions
	
	public void setDate() {
		//clickDatePicker.click();
		
		clickDatePicker.click();
		LocalDate stdate=start_date();
		nextSlide.click();
		end_date(stdate);
	}
	
	public void clickNext() {
		nextButton.click();
		
	}
	public LocalDate start_date()
	{
		LocalDate currentDate=LocalDate.now();
		LocalDate currentDate_Start =BaseClass.Start_date_modified(currentDate);
		String senddate=BaseClass.Dates(currentDate_Start);
		startDate.sendKeys(senddate);
		return currentDate_Start;
	}
	
	public void end_date(LocalDate stdate)
	{
		LocalDate currentDate_End =BaseClass.Start_date_modified(stdate);
		String senddate_End=BaseClass.Dates(currentDate_End);
		endDate.sendKeys(senddate_End);
	}
	
	
}
