package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HealthInsurancePage;
import PageObject.HomePage;
import baseClass.BaseClass;

public class Tc_3HealthInsuranceRunner extends BaseClass {
	public static String path;

	@Test(priority = 3, groups = { "sanity", "regression", "master" })
	public void healthInsurance() throws InterruptedException, IOException {

		logger.info("******Starting Homepage*******");
		try {
			HomePage hp = new HomePage(driver);
			hp.insuranceprod();

			logger.info("******Starting Health Insurance Page*******");

			HealthInsurancePage insurance = new HealthInsurancePage(driver);

			insurance.healthInsurance();
			path = screenShot("healthInsurance", driver);

			logger.info("******Health Insurance validation Completed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
			System.out.println("\n \n");
			System.out.println("Testcase 3 validated succesfully");
		} catch (Exception e) {
			logger.info("****** Health Insurance validation failed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
			e.printStackTrace();
			Assert.fail();
		}

	}

}
