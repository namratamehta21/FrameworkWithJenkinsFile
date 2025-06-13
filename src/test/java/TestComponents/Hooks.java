package TestComponents;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.Status;
import UtilityFile.ExtendReportManager;

public class Hooks 
{
	@Before
    public void beforeScenario(Scenario scenario) {
        // Create ExtentTest for scenario name once before scenario runs
        ExtendReportManager.test = ExtendReportManager.extent.createTest(scenario.getName());
        ExtendReportManager.test.log(Status.INFO, "Starting scenario: " + scenario.getName());
    }	
}
