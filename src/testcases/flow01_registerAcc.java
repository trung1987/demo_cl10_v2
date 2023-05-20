package testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import commons.BasedPage;
import commons.commonData;

public class flow01_registerAcc extends BasedPage {
	
	@Test
	public void TC01_register_success() {
		

		 test = extent.createTest("TC01_register_success"); // tao moi 1 test case voi name
		//ExtentTest : se chiu trach nhiem ghi log: info, pass, fail, step...
		
		String url = "https://demo.guru99.com/v4/";
		test.info("Go to url" +url);
		edge_driver.get(url);

		// Mazimize current window
		test.info("maximize browser");
		edge_driver.manage().window().maximize();

		// Click button here
		String xpathHere = "//a[@href='http://demo.guru99.com/']";
		WebElement clickBtnHere = edge_driver.findElement(By.xpath(xpathHere));
		test.info("Click button here");
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(funcs.screenshot_ele(clickBtnHere)).build()); //add ele screenshot
		clickBtnHere.click();

		String url_ads = "https://demo.guru99.com/v4/#google_vignette";
		
		String url_current = edge_driver.getCurrentUrl();
		test.info("get current url " + url_current);
		if (url_current.equals(url_ads)) {
			String iframeLink = "//iframe[contains(@id,'google_ads_iframe')]";
			WebElement iframeAdd = edge_driver.findElement(By.xpath(iframeLink));

			edge_driver.switchTo().frame(iframeAdd);
			String clickBtnAdd = "//div[contains(@role, 'button')]";
			WebElement clickBtnClose = edge_driver.findElement(By.xpath(clickBtnAdd));
			clickBtnClose.click();
			edge_driver.switchTo().defaultContent();
		}

		String xpathEmail = "//input[@name='emailid']";
		
		WebElement inputEmail = edge_driver.findElement(By.xpath(xpathEmail));

		Random randomEmail = new Random();
		String ramdomInputTextEmail = "hien" + randomEmail.nextInt(1000) + "@gmail.com";
		test.info(" input email " + ramdomInputTextEmail);
		inputEmail.sendKeys(ramdomInputTextEmail);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String xpathSubmit = "//input[@value='Submit']";
		WebElement btnSubmit = edge_driver.findElement(By.xpath(xpathSubmit));
		test.info(" click submit");
		btnSubmit.click();

		String xpathValueUserName = "//td[contains(text(),'User ID :')]/following-sibling::td";
		String xpathValuePassWord = "//td[contains(text(),'Password :')]/following-sibling::td";

		WebElement getUserName = edge_driver.findElement(By.xpath(xpathValueUserName));
		WebElement getPassWord = edge_driver.findElement(By.xpath(xpathValuePassWord));
		
		test.info(" get user name " +getUserName.getText() );
		test.info(" get pass " +getPassWord.getText() );
		// commonData.username = getUserName.getText();
		// commonData.password = getPassWord.getText();
		excel.WriteDataAtCell("./resources/data.xlsx", "login", commonData.login_row_start, commonData.login_col_user,
				getUserName.getText());
		excel.WriteDataAtCell("./resources/data.xlsx", "login", commonData.login_row_start, commonData.login_col_pwd,
				getPassWord.getText());

		
		//save report
		
//allure report
	}

//	@Test
	public void demowritedata() {
//		excel.WriteDataAtCell("./resources/data.xlsx", "login", commonData.login_row_start, commonData.login_col_user, "test user v2");
//		excel.WriteDataAtCell("./resources/data.xlsx", "login", commonData.login_row_start, commonData.login_col_pwd, "v2");
//	
//		String data ="vluong;hien;trung";
//		excel.WriteDataAtRow("./resources/data.xlsx", "login", commonData.login_row_start, commonData.login_col_pwd, data);

		String data = excel.ReadDataAtCell("./resources/data.xlsx", "product", commonData.login_row_start,
				commonData.login_col_pwd);
		System.out.println(data);
	}
}
