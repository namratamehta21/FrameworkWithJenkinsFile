package KingsleyGate.StepDef.Pages;

import UtilityFile.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPage extends AbstractComponents
{
    WebDriver driver;

    public ContactsPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//div[@class='hamburger-span']//*[name()='svg']")
    WebElement Menu;

    @FindBy(xpath = "(//div[@aria-label='Contacts'])")
    WebElement ContactsModule;

    @FindBy(css = "[data-testid='AddIcon']")
    WebElement AddContactBtn;

    @FindBy(xpath = "//input[@placeholder='Linkedin/Profile URL']")
    WebElement LinkedInProfileField;

    @FindBy(xpath = "(//button[normalize-space()='Get Profile Data'])")
    WebElement GetProfileDataBtn;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement FirstNameField;

    @FindBy(xpath  ="//button[contains(@class, 'MuiButton-outlinedPrimary') and text()='Save']")
    WebElement SaveContactBtn;

    @FindBy(xpath  ="//div[@id='notistack-snackbar']")
    WebElement SaveContactPopUpMsg;

    public void NavigatingToContactsPageAndClickOnAddContact()
    {
        waitForWebElementToAppear(Menu);
        Menu.click();
        waitForWebElementToBeClickable(ContactsModule);
        ContactsModule.click();
        waitForWebElementToBeClickable(AddContactBtn);
        AddContactBtn.click();
    }

    public void AddingContactUsingLinkedinProfile(String profile)
    {
        LinkedInProfileField.click();
        LinkedInProfileField.sendKeys(profile);
        GetProfileDataBtn.click();
        String FirstName= FirstNameField.getDomAttribute("value");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if(!FirstName.isEmpty())
        {
            SaveContactBtn.click();
        }
        else
        {
            wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(FirstNameField,"value","")));
            SaveContactBtn.click();
        }

        System.out.println(SaveContactPopUpMsg.getText());
    }

}
