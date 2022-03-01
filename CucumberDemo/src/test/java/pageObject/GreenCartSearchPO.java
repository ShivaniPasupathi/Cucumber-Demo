package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GreenCartSearchPO {
    public WebDriver driver;
    By search = By.xpath("//*[@class='search-keyword']");
    By confirmation = By.xpath("//h4[@class ='product-name']");
    By topDealsPage = By.linkText("Top Deals");

    public GreenCartSearchPO(WebDriver driver)
    {
        this.driver=driver;
    }

    public void searchItem(String searchTerm)
    {
        driver.findElement(search).sendKeys(searchTerm);
    }

    public String getProductName()
    {
        return driver.findElement(confirmation).getText().split("-")[0].trim();
    }

    public void clickTopDeals()
    {
        driver.findElement(topDealsPage).click();
    }

    public void clearSearch()
    {
        driver.findElement(search).clear();
    }
}
