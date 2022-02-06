package stepImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;

import java.util.Iterator;
import java.util.Set;

public class TopDealsPage {
    public DriverFactory driverFactory;
    public String topDealsSearch;
    public TopDealsPage(DriverFactory driverFactory)
    {
        this.driverFactory=driverFactory;
    }

    @And("user goes to Top Deals and does a search {string}")
    public void userGetsProductNameAndGoesToTopDeals(String searchKeyword) throws InterruptedException {
        switchWindow();
        WebElement search = driverFactory.driver.findElement(By.id("search-field"));
        search.sendKeys(searchKeyword);
        Thread.sleep(1000);
        topDealsSearch=driverFactory.driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//td[1]")).getText().trim();
        System.out.println(topDealsSearch);
    }

    public void switchWindow() //loosely coupled -> single responsible principle and separation of concerns
    {
        WebElement topDeals = driverFactory.driver.findElement(By.linkText("Top Deals"));
        topDeals.click();
        Set<String> window= driverFactory.driver.getWindowHandles();
        Iterator<String> itr=window.iterator();
        String parentWindow = itr.next();
        String childWindow1 = itr.next();
        driverFactory.driver.switchTo().window(childWindow1);
    }


    @Then("user is checks if Top deals is available for searched product")
    public void userIsChecksIfTopDealsIsAvailableForSearchedProduct() {
        Assert.assertEquals(driverFactory.confirmation, topDealsSearch);
    }
}
