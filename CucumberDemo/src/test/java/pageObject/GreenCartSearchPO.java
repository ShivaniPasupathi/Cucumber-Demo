package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreenCartSearchPO {
    WebDriver driver;
    By search = By.xpath("//*[@class='search-keyword']");
    By confirmation = By.xpath("//h4[@class ='product-name']");

    public GreenCartSearchPO(WebDriver driver)
    {
        this.driver=driver;
    }

    public void searchItem(String searchTerm)
    {
        driver.findElement(search).sendKeys(searchTerm);

    }
}
