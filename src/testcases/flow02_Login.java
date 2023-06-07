package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basedObjects.Obj_Login;
import commons.BasedPage;
import commons.ExcelUtil;
import commons.commonData;

public class flow02_Login extends BasedPage{
	
	Obj_Login login_screen ;
	
	@BeforeMethod
	public void initdata() {
		login_screen = new Obj_Login(edge_driver) ;
	}
	
	@Test
	public void TC01_login_success() {
		test = extent.createTest("TC01_login_success"); // tao moi 1 test case voi name
		String url_login = "https://demo.guru99.com/v4";
		test.info("Go to url" +url_login);
		edge_driver.get(url_login);
		
		ExcelUtil excel = new ExcelUtil();
		String username = excel.ReadDataAtCell("./resources/data.xlsx", "login", 
				commonData.login_row_start, commonData.login_col_user);
		String pass = excel.ReadDataAtCell("./resources/data.xlsx", "login", 
				commonData.login_row_start, commonData.login_col_pwd);
		
		login_screen.intput_username(test, username); //pass
	
		login_screen.intput_pwd(test, pass); //pw  : fail
		
	
		login_screen.click_login(test);
		
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
		test = extent.createTest("TC02_login_success");
		test.info("demo step 2 - TC02_login_success");
	}
}
