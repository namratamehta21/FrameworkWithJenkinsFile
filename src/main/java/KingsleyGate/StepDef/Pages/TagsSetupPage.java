package KingsleyGate.StepDef.Pages;

import UtilityFile.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;

public class TagsSetupPage extends AbstractComponents
{
    WebDriver driver;

    public TagsSetupPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='hamburger-span']//*[name()='svg']")
    WebElement Menu;

    @FindBy(xpath = "//div[contains(text(),'SETUP')]")
    WebElement SetupModuleIcon;

    @FindBy(xpath = "//div[normalize-space()='Tags Setup']")
    WebElement TagsSetupIcon;

    @FindBy(xpath = "//button[@id='add-tag-button']")
    WebElement AddTagsBtn;

    @FindBy(xpath = "//input[@id='outlined-basic']")
    WebElement TagNameField;

    @FindBy(xpath = "//span[normalize-space(text())='Colour Label']/ancestor::div[contains(@class,'MuiInputBase-root')]//input[@role='combobox']")
    WebElement ColorDropdownInput;

    @FindBy(xpath = "//span[contains(normalize-space(.),'Module')]/ancestor::div[contains(@class,'MuiInputBase-root')]//input[@role='combobox']")
    WebElement TagModulesField;

    @FindBy(css = "div[id='module-input'] div[class='MuiAutocomplete-root MuiAutocomplete-hasClearIcon MuiAutocomplete-hasPopupIcon AutoCompleteStyle animate-icon undefined css-yjucli'] button[title='Open'] svg")
    WebElement ActiveInactiveDropdown;

    @FindBy(xpath = "//div[normalize-space()='Save']")
    WebElement SaveTagBtn;

    @FindBy(xpath = "//div[@id='notistack-snackbar']")
    WebElement PopUpMsg;

    @FindBy(xpath = "//div[contains(text(),'CONTACTS')]")
    WebElement ContactsModule;

    @FindBy(xpath = "(//div[@role='row']//div[contains(@class, 'header-content') and contains(@class, 'header-font')])[1]")
    WebElement FirstContact;

    @FindBy(xpath = "//p[normalize-space()='+Tag']")
    WebElement AddTag;

    @FindBy(xpath = "//div[@class='MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root tag-auto-complete css-feqhe6']//button[@title='Open']//*[name()='svg']")
    WebElement AddTagDropDown;

    @FindBy(xpath = "//legend/span[normalize-space(.)='Select Tag']/ancestor::fieldset/preceding-sibling::input")
    WebElement SelectTagField;

    @FindBy(xpath = "//div[@class='d-flex align-items-center justify-content-center MuiBox-root css-0'][normalize-space()='Save']")
    WebElement SaveTagToContactBtn;

    @FindBy (xpath="//input[@type='text' and contains(@class, 'MuiInputBase-input') and contains(@class, 'MuiOutlinedInput-input')]")
    WebElement SearchTagField;

    @FindBy (xpath="//div[@class='MuiInputAdornment-root MuiInputAdornment-outlined MuiInputAdornment-sizeSmall css-5nvgmp']//button[@type='button']")
    WebElement SearchTagBtn;

    @FindBy (xpath="//*[name()='svg' and contains(@class, 'moveVerticalIconStyle') and @data-testid='MoreVertIcon']")
    WebElement ModificationBtn;

    @FindBy (xpath="//li[normalize-space()='Delete']")
    WebElement DeleteOptionBtn;

    @FindBy (xpath="//button[@id='button-add']")
    WebElement DeleteTagBtn;

    public void Navigate_Setup_TagsSetup()
    {	
        waitForWebElementToAppear(Menu);
        Menu.click();
        waitForWebElementToAppear(SetupModuleIcon);
        SetupModuleIcon.click();
        Menu.click();
        waitForWebElementToAppear(TagsSetupIcon);
        TagsSetupIcon.click();
    }

    public void clickOnAddTag()
    {
        waitForWebElementToAppear(AddTagsBtn);
        AddTagsBtn.click();
    }

    public void GiveDetailsOfTags(String TagName, String Color) 
    {
        waitForWebElementToAppear(TagNameField);
        TagNameField.sendKeys(TagName);
        waitForWebElementToAppear(ColorDropdownInput);
        ColorDropdownInput.click();

        waitUntilAttributeValue(ColorDropdownInput, "aria-expanded", "true");
        String listboxId = ColorDropdownInput.getAttribute("aria-controls");

        List<WebElement> options = driver.findElements
                (By.xpath("//ul[@id='" + listboxId + "']/li[@role='option']"));

        for (WebElement option : options) {
            String text = option.getText().trim();
            if (text.equalsIgnoreCase(Color)) {
                option.click();
                break;
            }
        }
        List<String> optionsToSelect = Arrays.asList("Contacts", "Companies");

     // Open the dropdown once before the loop
        waitForWebElementToAppear(TagModulesField);
        TagModulesField.click();
        waitUntilAttributeValue(TagModulesField, "aria-expanded", "true");

        // Locate all checkbox elements together with their labels
        List<WebElement> options1 = driver.findElements(By.xpath("//span[input[@type='checkbox']]"));

        for (String optionText : optionsToSelect) {
            boolean found = false;

            for (WebElement optionSpan : options1) {
                // Get the visible label text next to the checkbox input
                String label = optionSpan.getText().trim();

                if (label.equalsIgnoreCase(optionText)) {
                    WebElement checkbox = optionSpan.findElement(By.xpath(".//input[@type='checkbox']"));

                    if (!checkbox.isSelected()) {
                        checkbox.click();
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new RuntimeException("Option not found: " + optionText);
            }
        }

        // Close dropdown after selection
        waitUntilAttributeValue(TagModulesField, "aria-expanded", "false");


        SaveTagBtn.click();
    }

    /*public void selectTagModulesAndSaveTag() {
        List<String> optionsToSelect = Arrays.asList("Contacts", "Companies");

        for (String optionText : optionsToSelect) {

            waitForWebElementToAppear(TagModulesField);
            TagModulesField.click();

            waitUntilAttributeValue(TagModulesField, "aria-expanded", "true");

            String listboxId = TagModulesField.getAttribute("aria-controls");
            List<WebElement> options = driver.findElements(
                    By.xpath("//ul[@id='" + listboxId + "']/li[@role='option']")
            );
            waitForWebElementsToAppear(options);  // Custom method we'll define below

            boolean found = false;
            for (WebElement option : options) {
                if (option.getText().trim().equalsIgnoreCase(optionText)) {
                    option.click();
                    found = true;
                    waitUntilAttributeValue(TagModulesField, "aria-expanded", "false");
                    break;
                }
            }

            if (!found) {
                throw new RuntimeException("Option not found: " + optionText);
            }
        }

        SaveTagBtn.click();
        //waitForWebElementToAppear(PopUpMsg);
        //String popUpMsg = PopUpMsg.getText();
        //System.out.println(popUpMsg);
        //return  popUpMsg;
    }*/

    public void navigatesToContactModuleAndSelectAnyContact()
    {
        Menu.click();
        waitForWebElementToAppear(ContactsModule);
        ContactsModule.click();
        Menu.click();
        waitForWebElementToAppear(FirstContact);
        FirstContact.click();

    }

    public String AddTagToContacts(String TagName)
    {
        waitForWebElementToAppear(AddTag);
        AddTag.click();
        waitForWebElementToAppear(AddTagDropDown);
        AddTagDropDown.click();
        waitForWebElementToAppear(SelectTagField);
        SelectTagField.sendKeys(TagName);
        WebElement SelectTagOption= driver.findElement((By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]/li[contains(., '"+TagName+"')]")));
        waitForWebElementToAppear(SelectTagOption);
        SelectTagOption.click();
        SelectTagField.click();
        waitForWebElementToBeClickable(SaveTagToContactBtn);
        SaveTagToContactBtn.click();
        waitForWebElementToAppear(PopUpMsg);
        String PopupMsg= PopUpMsg.getText();
        System.out.println(PopupMsg);
        return PopupMsg;
    }

    public void SearchAndDeleteTag(String TagName)
    {
        waitForWebElementToAppear(SearchTagField);
        SearchTagField.sendKeys(TagName);
        SearchTagBtn.click();

        WebElement scrollContainer = driver.findElement(By.cssSelector("div.ag-body-horizontal-scroll-viewport"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollContainer);

        waitForWebElementToAppear(ModificationBtn);
        ModificationBtn.click();
        waitForWebElementToAppear(DeleteOptionBtn);
        DeleteOptionBtn.click();
        //waitForWebElementToAppear(DeleteTagBtn);
       // DeleteTagBtn.click();

    }

}
