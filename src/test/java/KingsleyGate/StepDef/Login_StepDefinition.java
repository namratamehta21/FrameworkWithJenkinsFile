package KingsleyGate.StepDef;

import TestComponents.HooksClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
    @Then("^User logged in with valid email and password$")
    public void user_logged_in_with_valid_email_and_password() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/main/java/Resources/Global.properties");
        prop.load(fis);

        String email = prop.getProperty("user_email");
        String password = prop.getProperty("user_password");

        Context.CP = Context.LP.Logging_Ignyte_App(email, password);
        Context.CompaniesPage = Context.LP.Logging_Companies_Page();
        Context.tagsSetupPage = Context.LP.Logging_TagsSetup_Page();
        Context.StageSetUpPage=Context.LP.Logging_StageSetUp_Page();
    }

    @Then("^User Logged in succesfully in Ignyte App and match the title (.+) of the home page$")
    public void user_logged_in_succesfully_in_ignyte_app(String Title)
    {

        System.out.println("Logged in");
        Assert.assertEquals(Context.LP.Verifying_Home_Page(),Title);
    }
}
