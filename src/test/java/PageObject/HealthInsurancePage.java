package PageObject;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HealthInsurancePage extends BasePage{

	
	public WebDriver driver;
	public HealthInsurancePage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(css="body > div:nth-child(9) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3)")List< WebElement> healthInsurance;
	
	
	//actions
	
	
	public void healthInsurance() {
		for(WebElement menu:healthInsurance) {
			
			System.out.println(menu.getText());
		}
	}
	
}

