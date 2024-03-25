package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	

	@BeforeClass(groups = { "smoke","regression","master" })
	@Parameters({"browser"})
	public void setup(String br) throws IOException 
	{
		
		logger=LogManager.getLogger(this.getClass());//Log4j
		
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default: System.out.println("No matching browser..");
		 return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.policybazaar.com/");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = { "smoke","regression","master" })
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(10000);
		driver.quit();
	}

 
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(8);
		return generatedString;
	}
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}

	
	public static String screenShot(String filename,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+".png");
		FileUtils.copyFile(src, trg);
		return trg.getAbsolutePath();
	}
	
	
}
