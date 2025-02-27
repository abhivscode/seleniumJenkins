package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ScreenshotUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupExtentReports() {
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setup() {
        logger.info("Setting up WebDriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            test.fail("Test failed. Screenshot: " + screenshotPath);
        }
        driver.quit();
        logger.info("Driver quit");
    }

    @AfterSuite
    public void tearDownExtentReports() {
        extent.flush();
    }
}
