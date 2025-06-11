package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import UtilityFile.ExtendReportManager;


@Listeners(ExtendReportManager.class)  

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"KingsleyGate.StepDef"},
        plugin = {
                "pretty",
                "json:target/cucumber-report.json"

        },
        tags = ("@SetUp"),
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider
    public Object[][] scenario() {
        return super.scenarios();
    }
}
