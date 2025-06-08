package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"KingsleyGate.StepDef"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-reports",
                "json:target/jsonReports/cucumber.json"
        },
        monochrome = true
)


public class TestRunner extends AbstractTestNGCucumberTests
{

    @DataProvider
    public Object[][] scenario()
    {
        return super.scenarios();
    }
}