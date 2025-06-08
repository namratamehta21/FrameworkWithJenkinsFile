package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"KingsleyGate.StepDef"},
        plugin = {
                "pretty",
                "json:Json/cucumber.json",  // JSON report output path
                "html:Reports/cucumber-reports.html"           // Optional default HTML report
        },
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider
    public Object[][] scenario() {
        return super.scenarios();
    }
}
