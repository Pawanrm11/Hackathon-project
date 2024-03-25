package PageObject;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;



public class PlansPage  extends BasePage{

	public WebDriver driver;
	
	public PlansPage(WebDriver driver) {
		super(driver);
		
	}
	//WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(15));
	
	//locators 
	
	@FindBy(css="#studentTrip")
	WebElement studentRadio;
	
	@FindBy(xpath="//input[@id='Traveller_1']")
	WebElement trvl1ChkBox;
	
	@FindBy(xpath="//input[@id='Traveller_2']")
	WebElement trvl2ChkBox;
	
	@FindBy(xpath="//select[@id='feet']")
	WebElement durationSelect;
	
	@FindBy(xpath="//div[@class='pqCtaWrapper']/button") 
	WebElement btnViewPlan;
	
	@FindBy(css="section[class='newFilterSection sort'] details summary")
	WebElement btnSort;
	
	@FindBy(xpath="//input[@id='17_sort']")
	WebElement lowToHigh;
	
	@FindBy(xpath="//section/article/div/div/div/div/div/p[1]")
	List<WebElement> insuranceProvider;
	
	@FindBy(xpath="//section/article/div/div/div/div/div/p[2]") 
	List<WebElement> insurancePlan;
	
	@FindBy(xpath="//section/article/div/div/div/div[2]/p[1]")
	List<WebElement> insuranceAmount;
	
	@FindBy(xpath="//section/article/div/div/div/div[3]/p/span") 
	List<WebElement> insurancePremium;
	

	
	//Actions
	
	public void filterData() throws InterruptedException
	{	
		try {
			studentRadio.click();
			trvl1_ChkBox();
			trvl2_ChkBox();
			Select select=new Select(durationSelect);
			select.selectByValue("1");
			btnViewPlan.click();
			Thread.sleep(2000);
			btnSort.click();
			lowToHigh.click();
			System.out.println("Filter Passed");
			}
			catch(Exception e) {
				System.out.println("Filter fail");
			}
	}
	
	public void printData() {
		for(int i=0;i<3;i++) {
			System.out.println("*****INSURANCE PLAN "+(i+1)+" *****");
			System.out.println("Plan: "+insurancePlan.get(i).getText());
			System.out.println("Amount: "+insurancePremium.get(i).getText());
			System.out.println("Company: "+insuranceProvider.get(i).getText());
			}
	}
	
	public void trvl1_ChkBox() throws InterruptedException
	{
		if(!trvl1ChkBox.isSelected())
		{
			trvl1ChkBox.click();
		}
	}
	
	public void trvl2_ChkBox() throws InterruptedException
	{
		if(!trvl2ChkBox.isSelected())
		{
			trvl2ChkBox.click();
		}
	}
	public void printExcel() throws IOException{
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\excelsheet\\output.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Policy Plans");
		for(int i =1;i<=3;i++) {
			XSSFRow row = sheet.createRow(i);
			for(int j=1;j<=3;j++) {
				String plan=insurancePlan.get(i).getText();
				row.createCell(1).setCellValue(plan);		
			}
			for(int j=1;j<=3;j++) {
				String premium=insurancePremium.get(i).getText();
				row.createCell(2).setCellValue(premium);			
			}
			for(int j=1;j<=3;j++) {
				String provider=insuranceProvider.get(i).getText();
				row.createCell(3).setCellValue(provider);
			}
		}	
		workbook.write(file);
		workbook.close();
		file.close();
	}
	
	
	
}