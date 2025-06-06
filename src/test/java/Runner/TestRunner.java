package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions

        (features = "src/test/resources/Features",
                glue = {"KingsleyGate.StepDef"},
                plugin = {
                        "pretty",
                        "html:Reports/cucumber-reports.html",
                        "json:Json/cucumber.json"
                },
                monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests
{

    @DataProvider
    public Object[][] scenario()
    {
        return super.scenarios();
    }
}