package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    WebDriver driver;

    public WebDriver open() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//global-properties.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String url = properties.getProperty("url");
        if (driver == null) {
            if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/Users/shivanip/Documents/CucumberDemo/CucumberDemo/Drivers/chromedriver");
                driver = new ChromeDriver();
            }
            if (properties.getProperty("browser") == "firefox") {
            }
            driver.get(url);
        }
        return driver;
    }
}
