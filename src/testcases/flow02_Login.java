package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import commons.BasedPage;
import commons.ExcelUtil;
import commons.commonData;

public class flow02_Login extends BasedPage{

	@Test
	public void TC01_login_success() {
		test = extent.createTest("TC01_login_success"); // tao moi 1 test case voi name
		String url_login = "https://demo.guru99.com/v4";
		test.info("Go to url" +url_login);
		edge_driver.get(url_login);
		
		String xpathUserName = "//input[contains(@name,'uid')]";
		WebElement inputUserName = edge_driver.findElement(By.xpath(xpathUserName));
		
		String xpathPassWord = "//input[contains(@name,'password')]";
		WebElement inputPassWord = edge_driver.findElement(By.xpath(xpathPassWord));
		ExcelUtil excel = new ExcelUtil();
		String username = excel.ReadDataAtCell("./resources/data.xlsx", "login", 
				commonData.login_row_start, commonData.login_col_user);
		String pass = excel.ReadDataAtCell("./resources/data.xlsx", "login", 
				commonData.login_row_start, commonData.login_col_pwd);
		
		inputUserName.sendKeys(username);
		inputPassWord.sendKeys(pass);
		
		
		String xpathLogin = "//input[contains(@name,'btnLogin')]";
		WebElement btnLogin = edge_driver.findElement(By.xpath(xpathLogin));
		btnLogin.click();
		
		
		String xpathConfirmId = "//td[contains(text(),'Manger Id')]";
		WebElement confirmUserName = edge_driver.findElement(By.xpath(xpathConfirmId));
		
		String userNameExpect = confirmUserName.getText();
		System.out.println(userNameExpect);
		
		String userNameActual = "Manger Id :"+" "+username;
		System.out.println(userNameActual);
		Assert.assertEquals(userNameActual, userNameExpect);
		
		
	}
	
	@Test
	public void TC02_login_success() {
		test = extent.createTest("TC01_login_success");
		test.info("demo step 2 - TC02_login_success");
	}
}
