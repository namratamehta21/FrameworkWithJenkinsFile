package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"KingsleyGate.StepDef","TestComponents"},
        plugin = {
                "pretty",
                "json:target/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@StageSetUp",
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
