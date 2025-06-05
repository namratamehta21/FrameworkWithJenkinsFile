package TestComponents;

import KingsleyGate.StepDef.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.Dimension;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class HooksClass
{
    WebDriver driver;
    LoginPage LP;

    public WebDriver initializeDriver() throws IOException
    {

        Properties prop = new Properties();
        FileInputStream FIS=new FileInputStream(System.getProperty("user.dir")
                +"//src//main//java//Resources//Global.properties");
        prop.load(FIS);
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        String URL=prop.getProperty("url");
        String headlessFlag = System.getProperty("headless") != null
                ? System.getProperty("headless")
                : prop.getProperty("headless");
        boolean isHeadless = headlessFlag.equalsIgnoreCase("true");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) {
                options.addArguments("--headless=new"); // or "--headless" for older versions
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-gpu");
            }
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.addArguments("--headless");
                options.addArguments("--width=1920");
                options.addArguments("--height=1080");
            }
            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            if (isHeadless) {
                options.addArguments("headless");
                options.addArguments("disable-gpu");
                options.addArguments("window-size=1920,1080");
            }
            driver = new EdgeDriver(options);

        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get(URL);
        System.out.println("Selected browser: " + browser);
        return driver;
    }

    public LoginPage launchApp() throws IOException

    {
        this.driver=initializeDriver();
        LP=new LoginPage(driver);
        return LP;

    }


    public void CloseWindow()
    {
        driver.close();
    }

}
