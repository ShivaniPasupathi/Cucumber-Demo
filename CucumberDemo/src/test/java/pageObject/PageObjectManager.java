package pageObject;

import org.openqa.selenium.WebDriver;
import stepImplementation.GreenCartSearch;
import stepImplementation.TopDealsPage;

// Factory design pattern
public class PageObjectManager {

    public WebDriver driver;
    public GreenCartSearchPO greenCartSearchPO;
    public TopDealsPagePO topDealsPagePO;

    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public GreenCartSearchPO getGreenCartPage()
    {
        greenCartSearchPO=new GreenCartSearchPO(driver);
        return greenCartSearchPO;
    }

    public TopDealsPagePO getTopDealsPagePO()
    {
        topDealsPagePO=new TopDealsPagePO(driver);
        return topDealsPagePO;
    }
}
