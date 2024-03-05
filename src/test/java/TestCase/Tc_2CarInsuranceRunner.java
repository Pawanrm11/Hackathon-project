package TestCase;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.CarInsurancePage;
import PageObject.HomePage;
import baseClass.BaseClass;
import junit.framework.Assert;

public class Tc_2CarInsuranceRunner extends BaseClass{
	
	public static String path;
	
	
	@Test(priority=2,groups= {"regression","master"})
	public void carInsurance() throws IOException {
		
		logger.info("******Starting Homepage*******");
		try {
		HomePage hp = new HomePage(driver);
		hp.selectCarInsurance(); 
		
		logger.info("******Starting Car Insurance Page*******");
		CarInsurancePage carIns = new CarInsurancePage(driver);
		
		carIns.carNumber();
		carIns.rtoNumber();
		carIns.carBrand();
		carIns.carName();
		carIns.carVariant();
		carIns.custName(randomeString());
		carIns.emailId(randomeString());
		carIns.mobileNumber("12"+randomeNumber());
		carIns.clickViewprice();
		path=screenShot("carInsurance", driver);
		carIns.errorMessage();
		

		logger.info("****** Car Insurance validation Completed*******");
		logger.info("         ===========================             ");
		logger.info("                                 ");
		}catch(Exception e) {
			logger.info("****** Car Insurance validation failed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
			Assert.fail();
		}
	}

}
