package runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.*;
import com.cucumber.listener.ExtentCucumberFormatter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions
(
		plugin = {"json:target/positive/cucumber.json", "pretty", "html:target/positive/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
		features = {"src/test/resources/features/TheAutomatedTester.feature"},
		glue = "steps"
		//tags = { "*" }
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {
	public static Properties config = null;
	public static WebDriver driver;
	public static Logger logger;
	//,	tags = { "" }
	@BeforeClass
	public void generateHTMLReports() {
//		      Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
				SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
				Date curDate = new Date();
				String strDate = sdf.format(curDate);
				String fileName = System.getProperty("user.dir")+"\\ExtentReport\\The Automated Tester Report " + strDate+".html";
				File newFile = new File(fileName);
				ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,true);
				ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

		//static report name
//		String fileName = System.getProperty("user.dir")+"\\ExtentReport\\extentreports.html";
//		File newFile = new File(fileName);
//		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,true);
		// Loads the extent config xml to customize on the report.
		//ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome ");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "79.0.45");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");
		// Also you can add system information using a hash map
		//		Map systemInfo = new HashMap();
		//		systemInfo.put("Cucumber version", "v1.2.3");
		//		systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
		//		ExtentCucumberFormatter.addSystemInfo(systemInfo);    
	}

	public void LoadConfigProperty() throws IOException {
		
		logger=Logger.getLogger("Selenide Cucumber"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
		config.load(ip);
	}

	

}


