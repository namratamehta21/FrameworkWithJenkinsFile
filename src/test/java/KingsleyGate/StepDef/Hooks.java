package KingsleyGate.StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.Status;

import TestComponents.HooksClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import UtilityFile.ExtentReporterNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;
    public static ExtentReports extent = ExtentReporterNG.getReportObject();
    public static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        try {
            // Initialize your driver here, example:
            driver = new HooksClass().initializeDriver();

            // Create ExtentTest for current scenario
            test = extent.createTest(scenario.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // Capture screenshot as Base64 string (no file saved)
                String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

                // Attach Base64 screenshot to Extent Report
                test.fail("Scenario Failed. Screenshot attached.")
                    .addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            test.pass("Scenario passed successfully.");
        }

        extent.flush();

        if (driver != null) {
            driver.quit();
        }
    }
}
