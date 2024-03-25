package TestCase;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObject.CarInsurancePage;
import PageObject.CarInsurancePage2;
import PageObject.HomePage;
import baseClass.BaseClass;


public class Tc_2CarInsuranceRunner extends BaseClass {

	public static String path;

	@Test(priority = 2, groups = { "regression", "master" })
	public void carInsurance() throws  InterruptedException, IOException {

		logger.info("******Starting Homepage*******");
		//try {

			HomePage hp = new HomePage(driver);
			hp.selectCarInsurance();
			Thread.sleep(5000);

			logger.info("******Starting Car Insurance Page*******");
			try {
				if (driver.findElement(By.xpath("//span[normalize-space()='or']")).isDisplayed()) {
					logger.info("******hi 1*******");

					CarInsurancePage carIns = new CarInsurancePage(driver);

					carIns.carNumber();
					carIns.rtoNumber();
					carIns.carBrand();
					carIns.carName();
					carIns.carVariant();
					carIns.custName(randomeString());
					carIns.emailId(randomeString());
					carIns.mobileNumber("12" + randomeNumber());
					carIns.clickViewprice();
					path = screenShot("carInsurance", driver);
					carIns.errorMessage();
					System.out.println("\n \n");
					System.out.println("Testcase 2 validated succesfully");
					logger.info("****** Car Insurance validation Completed*******");
					logger.info("         ===========================             ");
					logger.info("                                 ");
				}
			} catch (Exception e) {

				logger.info("******method  2*******");

				CarInsurancePage2 carIns = new CarInsurancePage2(driver);
				carIns.carInsurance();
				carIns.fillDetails(randomeString(), "12" + randomeNumber(), randomeString());
				path = screenShot("carInsurance", driver);
				carIns.errorMsg();
				logger.info("****** Car Insurance validation Completed*******");
				logger.info("         ===========================             ");
				logger.info("                                 ");
				System.out.println("\n \n");
				System.out.println("Testcase 2 validated succesfully");
			}

		/* }catch (Exception e) {
			logger.info("****** Car Insurance validation failed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
			Assert.fail();
		}*/
	}

}
