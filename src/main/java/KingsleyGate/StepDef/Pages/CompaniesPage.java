package KingsleyGate.StepDef.Pages;

import UtilityFile.AbstractComponents;
import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CompaniesPage extends AbstractComponents
{
    WebDriver driver;

    public CompaniesPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='hamburger-span']//*[name()='svg']")
    WebElement Menu;

    @FindBy(xpath = "//div[contains(text(),'COMPANIES')]")
    WebElement CompaniesModuleIcon;

    @FindBy(xpath = "//span[@class='MuiBox-root css-0']")
    WebElement AnyOneCompany;

    @FindBy(xpath = "//div[@id='contact-search']//input[@placeholder='Search']")
    WebElement SearchFieldCompany;

    @FindBy(xpath = "//span[@class='search-icon p-0']")
    WebElement SearchBtn;

    @FindBy(xpath = "//span[@class='header-font header-text fs-18 mr-2 MuiBox-root css-0']")
    WebElement CompanyName_SlideBar;

    @FindBy(xpath = "//span[normalize-space()='Columns']")
    WebElement ColumnTab_Sidebar;

    @FindBy(xpath = "(//div[@class='ag-column-select-header-checkbox ag-labeled ag-label-align-right ag-checkbox ag-input-field'])")
    WebElement SelectAllColumn;

    @FindBy(xpath = "//span[@class='ag-column-select-column-label']")
    List<WebElement> ListOfColumns;


    public void Navigating_to_Companies_module()
    {
        Menu.click();
        waitForWebElementToAppear(CompaniesModuleIcon);
        CompaniesModuleIcon.click();
        Menu.click();
    }

    public String verifies_Companies_pageTitle()
    {
        String Companies_pageTitle= driver.getTitle();
        return Companies_pageTitle;
    }

    public void Select_any_one_company()
    {
        waitForWebElementToAppear(AnyOneCompany);
        AnyOneCompany.click();
        if (AnyOneCompany.getText().contains(CompanyName_SlideBar.getText()))
        {
            System.out.println("Companies are same");
        }
        else
        {
            System.out.println("Companies are not same");
        }
    }

    public String Search_for_a_Company(String Company_Name)
    {
        SearchFieldCompany.sendKeys(Company_Name);
        SearchBtn.click();
        return AnyOneCompany.getText();
    }

    public void ColumnTabOnCompanies()
    {
        SearchBtn.click();
        waitForWebElementToAppear(AnyOneCompany);
        ColumnTab_Sidebar.click();
    }

//    public void AddColumnToGrid()
//    {
//        waitForWebElementToAppear(SelectAllColumn);
//        SelectAllColumn.click();
//
//        String[] ColumnRequired =
//                {
//                        "Name","Location","Company Status","Industry",
//                        "Revenue Range","Employee Range From","Employee Range to",
//                        "Updated By", "Capital Structure","Created By"
//                };
//
//        int count = 0;
//        for (String expected : ColumnRequired) {
//
//            List<WebElement> columns = ListOfColumns;
//
//            for (WebElement element : columns) {
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//
//                String ColumnText = element.getText().trim();
//                if (ColumnText.equalsIgnoreCase(expected)) {
//                    element.click();
//                    count++;
//                    break;
//                }
//            }
//
//            if (count == ColumnRequired.length) {
//                break;
//            }
//        }
//    }

    public void AddColumnToGrid() {
        waitForWebElementToAppear(SelectAllColumn);
        SelectAllColumn.click();

        String[] ColumnRequired = {
                "Name", "Location", "Company Status", "Created By",
                "Industry", "Revenue Range", "Employee Range From",
                "Employee Range to", "Updated By", "Capital Structure"
        };

        int count = 0;
        WebElement scrollContainer = driver.findElement(By.xpath("//div[contains(@class, 'ag-virtual-list-viewport')]"));

        for (String expected : ColumnRequired) {
            boolean found = false;

            // Scroll Down
            for (int i = 0; i < 30 && !found; i++) {
                List<WebElement> columns = driver.findElements(By.xpath("//span[@class='ag-column-select-column-label']"));
                for (WebElement element : columns) {
                    try {
                        String columnText = element.getText().trim();
                        if (columnText.equalsIgnoreCase(expected)) {
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                            count++;
                            found = true;
                            break;
                        }
                    } catch (StaleElementReferenceException ignored) {
                        // We'll retry on the next loop
                    }
                }

                if (!found) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 50;", scrollContainer);
                    waitForDomUpdate();
                }
            }


            if (!found) {
                for (int i = 0; i < 30 && !found; i++) {
                    List<WebElement> columns = driver.findElements(By.xpath("//span[@class='ag-column-select-column-label']"));
                    for (WebElement element : columns) {
                        try {
                            String columnText = element.getText().trim();
                            if (columnText.equalsIgnoreCase(expected)) {
                                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                                count++;
                                found = true;
                                break;
                            }
                        } catch (StaleElementReferenceException ignored) {
                            // Try again
                        }
                    }

                    if (!found) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop -= 50;", scrollContainer);
                        waitForDomUpdate();
                    }
                }
            }

            if (count == ColumnRequired.length) {
                break;
            }
        }
    }

    public void verifySelectedColumnsInGrid() {
        String[] ColumnRequired = {
                "Name", "Location", "Company Status", "Created By",
                "Industry", "Revenue Range", "Employee Range From",
                "Employee Range to", "Updated By", "Capital Structure"
        };

        WebElement horizontalScrollContainer = driver.findElement(By.xpath("//div[@class='ag-body-horizontal-scroll-viewport']"));
        List<String> verifiedColumns = new ArrayList<>();

        for (String expected : ColumnRequired) {
            boolean found = false;

            // Try scrolling forward (right)
            for (int i = 0; i < 30 && !found; i++) {
                List<WebElement> headers = driver.findElements(By.xpath("//span[@class='ag-header-cell-text']"));
                for (WebElement header : headers) {
                    if (header.getText().trim().equalsIgnoreCase(expected)) {
                        System.out.println("✅ Verified column in grid: " + expected);
                        verifiedColumns.add(expected);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 100;", horizontalScrollContainer);
                    waitForDomUpdate();
                }
            }

            // If not found, try scrolling backward (left)
            if (!found) {
                for (int i = 0; i < 30 && !found; i++) {
                    List<WebElement> headers = driver.findElements(By.xpath("//span[@class='ag-header-cell-text']"));
                    for (WebElement header : headers) {
                        if (header.getText().trim().equalsIgnoreCase(expected)) {
                            System.out.println("✅ Verified column in grid (after scrolling back): " + expected);
                            verifiedColumns.add(expected);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft -= 100;", horizontalScrollContainer);
                        waitForDomUpdate();
                    }
                }
            }

            if (!found) {
                System.out.println("❌ Column not found in grid: " + expected);
            }
        }

        System.out.println("✅ All verified columns: " + verifiedColumns);
    }



}
