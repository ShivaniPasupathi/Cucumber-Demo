package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver open(String browserType)
    {
        if(browserType.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/Users/shivanip/Documents/Selenium/Drivers/chromedriver");
            return new ChromeDriver();
        }
        return null;
    }
}
