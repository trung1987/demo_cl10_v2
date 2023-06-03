package commons;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class commonFuncs {

	
	public void sleepXtimes(int n) {
		
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String screenshot_ele(WebElement ele) {
		File screenshotFile = ele.getScreenshotAs(OutputType.FILE); //chup 1 ele
		String new_name = "ele_" + getTimeStemp() + ".png"; //"screenshot_20052023_201658.png
		
		//copy to report folder
		try {
			FileUtils.copyFile(screenshotFile , new File("./report/"+new_name));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return new_name;
	}
	
	public String screenshot_page(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//capture screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String new_name = "screenshot_" + getTimeStemp() + ".png"; //"screenshot_20052023_201658.png
		
		//copy to report folder
		try {
			FileUtils.copyFile(screenshotFile , new File("./report/"+new_name));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return new_name;
	}
	
	//return ve  20052023_201658
	public String getTimeStemp() {
		LocalDateTime myDateObj = LocalDateTime.now();
	   // System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

	    String formattedDate = myDateObj.format(myFormatObj);
	   // System.out.println("After formatting: " + formattedDate);
	    return formattedDate;
	}
	
	public void open_url(WebDriver driver, ExtentTest test, String url) {
		test.info("Go to url" +url);
		System.out.println("Go to url" +url);
		driver.get(url);
	}
	
	public void maximize_brower(WebDriver driver, ExtentTest test) {
		test.info("maximize browser");
		System.out.println("maximize browser");
		driver.manage().window().maximize();
	}
	
	public String get_current_url(WebDriver driver, ExtentTest test) {
		String url = driver.getCurrentUrl();
		test.info("get current url: " + url);
		System.out.println("get current url: " + url);
		return url;
	}
	
	public void element_click(WebDriver driver, ExtentTest test, String xpath) {
		WebElement btn_ele = driver.findElement(By.xpath(xpath));
		
		test.info("Click button - xpath " + xpath);
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenshot_ele(btn_ele)).build()); //add ele screenshot
		System.out.println("Click button - xpath " + xpath);
		btn_ele.click();
	}
	
	public void element_sendkey(WebDriver driver, ExtentTest test, String xpath,String data) {
		WebElement btn_ele = driver.findElement(By.xpath(xpath));
		
		test.info("Send data '" + data +"' into - xpath " + xpath);
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenshot_ele(btn_ele)).build()); //add ele screenshot
		System.out.println("Send data '" + data +"' into - xpath " + xpath);
		btn_ele.sendKeys(data);
	}
}
