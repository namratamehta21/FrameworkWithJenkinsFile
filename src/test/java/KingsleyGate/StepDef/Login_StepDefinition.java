package KingsleyGate.StepDef;

import KingsleyGate.StepDef.Pages.LoginPage;
import TestComponents.HooksClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.testng.Assert;

import java.io.IOException;

public class Login_StepDefinition
{
    SharedContext Context;

    public Login_StepDefinition (SharedContext Context)
    {
        this.Context = Context;
    }

    @Given("User landed on Ignyte App")
    public void user_landed_on_ignyte_app() throws IOException
    {
        Context.LP=new HooksClass().launchApp();
    }
    @When("^User logged in With valid Email (.+) and Password (.+)$")
    public void user_logged_in_with_valid_email_and_password(String Email, String Password) {

        Context.CP=Context.LP.Logging_Ignyte_App(Email, Password);

    }
    @Then("^User Logged in succesfully in Ignyte App and match the title (.+) of the home page$")
    public void user_logged_in_succesfully_in_ignyte_app(String Title)
    {

        System.out.println("Logged in");
        Assert.assertEquals(Context.LP.Verifying_Home_Page(),Title);
    }
}
