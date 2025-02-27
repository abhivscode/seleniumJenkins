package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigManager;
import utilities.JSONReader;
import utilities.TestData;


public class LoginTest extends BaseTest{
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);


    @Test
    public void validLoginTest() {
        TestData data = JSONReader.getDataFromJson("src/test/resources/testdata.json", TestData.class);

        test = extent.createTest("Valid Login Test");
        driver.get(ConfigManager.VALID_LOGIN_URL);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(ConfigManager.USERNAME);           //-- THIS IS THE METHODS
        loginPage.enterPassword(ConfigManager.PASSWORD);		  //-- THIS IS THE METHODS
        loginPage.clickLogin();						  //-- THIS IS THE METHODS
        homePage.getWelcomeMessage();				//-- THIS IS THE METHODS
        System.out.println("we are in new LoginTest 30 nov");
        loginPage.clickOnHomeButton();
        
        // Create Actions object
        Actions actions = new Actions(driver);

        // Simulate pressing the Page Down key
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        loginPage.enterEmailID(data.login.valid.username);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        test.pass("Login test passed successfully");
        logger.info("valid login successful");
    }
}
