package utilities;

import org.openqa.selenium.WebDriver;
import pageObject.PageObjectManager;
import stepImplementation.HookExample;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class UtilitySetUp {

    public String confirmation;
    public PageObjectManager pageObjectManager;
    public DriverFactory driverFactory;
    public GenericUtils genericUtils;

    public UtilitySetUp() throws IOException {
        driverFactory = new DriverFactory();
        pageObjectManager = new PageObjectManager(driverFactory.open());
        genericUtils = new GenericUtils(driverFactory.open());
    }

}
