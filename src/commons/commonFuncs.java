package commons;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
