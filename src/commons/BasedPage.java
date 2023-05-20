package commons;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasedPage {
	public static WebDriver edge_driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExcelUtil excel = new ExcelUtil();
	public static commonFuncs funcs= new commonFuncs();
	@BeforeTest
	@Parameters({"browser"})
	public WebDriver initDriver(String browser) {
		extent = new ExtentReports(); // khai bao xu dung extent report
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/Automation_"+browser+".html"); // tro report den folder
		extent.attachReporter(spark); // attached spart report vao trinh quan ly report cua extent report
		
		if (browser.equalsIgnoreCase("chrome")){
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();						
			chromePrefs.put("profile.default_content_settings.popups", 0);		// tat pop up file browser, auto accept				
			chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "resources");	// config folder download					
			
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			
			option.setExperimentalOption("prefs", chromePrefs);			
			
			
			edge_driver = new ChromeDriver(option);
		} else if(browser.equalsIgnoreCase("firefox")) {
			edge_driver = new FirefoxDriver();
			
		} else {
			edge_driver = new EdgeDriver();
			
		}
		
		
		//String url = "https://the-internet.herokuapp.com/iframe";
		
		//Mazimize current window
		edge_driver.manage().window().maximize();
		
		edge_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45)); // set page load timeout
		
		
		return edge_driver;
	}
	
	@AfterMethod
	public void saveExtentRp() {
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(funcs.screenshot_page(edge_driver)).build());
		extent.flush();
	}
	
	@AfterTest
	public void cleanUp() {
		edge_driver.quit();
	}
}
