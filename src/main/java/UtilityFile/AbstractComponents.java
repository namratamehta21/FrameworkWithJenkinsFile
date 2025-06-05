package UtilityFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents
{
    WebDriver driver;


    public AbstractComponents(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForWebElementToAppear(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForWebElementToBeClickable(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));

    }

    public void waitForDomUpdate() {
        new WebDriverWait(driver, Duration.ofMillis(300))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//span[@class='ag-column-select-column-label']")));
    }


}
