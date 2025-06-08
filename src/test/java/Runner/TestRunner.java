package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"KingsleyGate.StepDef"},
        plugin = {
                "pretty",
                "json:target/cucumber-report.json"
                // No need to add publish plugin manually — environment variable handles it
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider
    public Object[][] scenario() {
        return super.scenarios();
    }
}
