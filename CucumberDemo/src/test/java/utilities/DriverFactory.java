package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.PageObjectManager;

public class DriverFactory {

    public WebDriver driver;
    public String confirmation;
    public PageObjectManager pageObjectManager;

    public DriverFactory()
    {
        pageObjectManager= new PageObjectManager(driver);
    }

    public static WebDriver open(String browserType)
    {
        if(browserType.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/Users/shivanip/Documents/CucumberDemo/CucumberDemo/Drivers/chromedriver");
            return new ChromeDriver();
        }
        return null;
    }
}
