package utilities;

import org.openqa.selenium.WebDriver;
import pageObject.PageObjectManager;

public class UtilitySetUp {
    public WebDriver driver;
    public String confirmation;
    public PageObjectManager pageObjectManager;
    public DriverFactory driverFactory;

    public UtilitySetUp()
    {
        driverFactory=new DriverFactory();
        pageObjectManager= new PageObjectManager(driverFactory.open());
    }
}
