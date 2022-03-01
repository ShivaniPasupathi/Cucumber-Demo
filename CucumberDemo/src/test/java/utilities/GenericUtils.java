package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
    public WebDriver driver;
    public GenericUtils(WebDriver driver)
    {
        this.driver=driver;
    }
    public void switchWindow()
    {
        Set<String> window= driver.getWindowHandles();
        Iterator<String> itr=window.iterator();
        String parentWindow = itr.next();
        String childWindow1 = itr.next();
        driver.switchTo().window(childWindow1);
    }
}
