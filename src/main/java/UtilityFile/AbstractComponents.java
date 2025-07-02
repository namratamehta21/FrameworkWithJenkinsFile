package UtilityFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForWebElementToBeClickable(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));

    }

    public void waitForDomUpdate() {
        new WebDriverWait(driver, Duration.ofMillis(300))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//span[@class='ag-column-select-column-label']")));
    }

    public void waitForPageToLoad(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );
    }

    public void waitUntilAttributeValue(WebElement element, String attribute, String expectedValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(driver -> expectedValue.equals(element.getAttribute(attribute)));
    }

    public void waitForWebElementsToAppear(List<WebElement> elements) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> elements.stream().allMatch(WebElement::isDisplayed));
    }

    public void waitForElementToAppear(String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
