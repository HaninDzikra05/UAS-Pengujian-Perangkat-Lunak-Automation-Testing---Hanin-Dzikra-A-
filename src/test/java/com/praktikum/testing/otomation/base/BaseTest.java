package com.praktikum.testing.otomation.base;

import com.aventstack.extentreports.*;
import com.praktikum.testing.otomation.utils.ExtentReportManager;
import com.praktikum.testing.otomation.utils.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        extent = ExtentReportManager.getExtentReports();
        extent.setSystemInfo("Project", "DemoBlaze Automation");
        extent.setSystemInfo("Environment", "Demo");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {

        test = extent.createTest(method.getName());
        test.log(Status.INFO, "Test Started: " + method.getName());

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        test.log(Status.INFO, "Browser launched: Chrome");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String url = "https://www.demoblaze.com/";
        test.log(Status.INFO, "Navigate to URL: " + url);
        driver.get(url);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbarExample")));
        test.log(Status.INFO, "Navbar displayed successfully");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed Successfully");
            test.addScreenCaptureFromPath(screenshotPath, "Final Screenshot - PASS");

        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed");
            test.fail(result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");

        } else {
            test.log(Status.SKIP, "Test Skipped");
        }

        if (driver != null) {
            driver.quit();
            test.log(Status.INFO, "Browser closed");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (extent != null) {
            extent.flush();
        }
    }
}

