package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopDealsPagePO {
    public WebDriver driver;
    By search = By.xpath("//*[@id='search-field']");
    By confirmation = By.xpath("//*[@class='table table-bordered']/tbody/tr/td[1]");

    public TopDealsPagePO(WebDriver driver)
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

}
