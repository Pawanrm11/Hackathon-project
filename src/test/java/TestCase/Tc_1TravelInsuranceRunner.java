package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CountPage;
import PageObject.DatePickerPage;
import PageObject.HomePage;
import PageObject.MedicalConditionPage;
import PageObject.MobileNumberPage;
import PageObject.PlansPage;
import PageObject.TravelInsurancepage;
import baseClass.BaseClass;

public class Tc_1TravelInsuranceRunner extends BaseClass {
	public static String path;

	@Test(priority = 1, groups = { "smoke","regression","master" })
	public void travelInsurance() throws IOException, InterruptedException {

		logger.info("******Starting Homepage*******");
		try {
			HomePage hp = new HomePage(driver);
			hp.selectTravelInsurance();

			logger.info("******Starting Travel Insurance Page*******");

			TravelInsurancepage travelInsurance = new TravelInsurancepage(driver);
			travelInsurance.setGermany();
			travelInsurance.setUSA();
			travelInsurance.clickNext();

			DatePickerPage date = new DatePickerPage(driver);
			date.setDate();
			date.clickNext();

			CountPage count = new CountPage(driver);
			count.setCount();
			count.selectAge();
			count.clickNext();

			MedicalConditionPage status = new MedicalConditionPage(driver);
			status.medicalCondition();
			
			status.clickNext();

			MobileNumberPage num = new MobileNumberPage(driver);
			num.mobileNumber("98" + randomeNumber());
			num.viewplans();

			PlansPage plan = new PlansPage(driver);
			Thread.sleep(6000);
			plan.filterData();
			Thread.sleep(3000);
			path = screenShot("travelInsurance", driver);
			plan.printData();
			System.out.println("\n \n");
			System.out.println("Testcase 1 validated succesfully");
			plan.printExcel();

			logger.info("****** Travel Insurance validation Completed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
		} catch (Exception e) {
			logger.info("****** Travel Insurance validation failed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
