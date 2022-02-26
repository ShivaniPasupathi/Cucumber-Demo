package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.PageObjectManager;

public class DriverFactory {

    WebDriver driver;

    public WebDriver open()
    {
            System.setProperty("webdriver.chrome.driver", "/Users/shivanip/Documents/CucumberDemo/CucumberDemo/Drivers/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
            return driver;
    }
}
