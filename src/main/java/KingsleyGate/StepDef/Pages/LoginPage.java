package KingsleyGate.StepDef.Pages;

import UtilityFile.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents
{
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        //initialization
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath= "(//form//div/input[contains(@name,'username')])[last()]")
    WebElement userEmail;
    @FindBy(xpath = "(//form//div/input[contains(@name,'password')])[last()]")
    WebElement password;
    @FindBy(xpath="(//input[@name='signInSubmitButton'])[last()]")
    WebElement LoginBtn;

    public ContactsPage Logging_Ignyte_App(String email,String pass)
    {
        System.out.println(driver.getTitle());
        userEmail.click();
        userEmail.sendKeys(email);
        password.click();
        password.sendKeys(pass);
        LoginBtn.click();
        driver.get("https://qa01.non-prod.ignyte.app/oauth2/idpresponse?code=d8a4aac6-c4a4-4e9b-ba3f-2ead975e262e&state=+w1IM3cGUI7T7qZo9qZ5AzPCBexLTRSKDc6LmDK2CWbJKIbBdz/cWYAPOsUC7k3KN+aiV9TmcmdU6cN7I1DTCJwUNaehSTNnGAdJdrsLmOCH2LZl32xXt45DAjYHgDXb3vTbilsU/vOB4A9gByo7/cHDWzslJ/zKZLd5wRjol8aCWl0S8ine4Rs2KjEqXaOiz8I8cRZFXCikdk6XeeTu97KQXdrZBCZ19MNIIzj9WhZ+7nOphG3y2pX8dDKtvNXsbdzL");
        ContactsPage CP=new ContactsPage(driver);
        return CP;
    }
    
    public CompaniesPage Logging_Companies_Page()
    {
        CompaniesPage Companies_Page=new CompaniesPage(driver);
        return Companies_Page;
    }
    public TagsSetupPage Logging_TagsSetup_Page()
    {
        TagsSetupPage tagsSetupPage=new TagsSetupPage(driver);
        return tagsSetupPage;
    }
    public StageSetUpPage Logging_StageSetUp_Page()
    {
        StageSetUpPage stageSetUpPage= new StageSetUpPage(driver);
        return stageSetUpPage;
    }

    public String Verifying_Home_Page()
    {
        String title= driver.getTitle();
        return title;
    }

}
