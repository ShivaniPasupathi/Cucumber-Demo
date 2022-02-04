package stepImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GreenCartSearch {
    WebDriver driver;
    public String topDealsSearch;
    public String confirmation;

    @Given("user opens Greenkart Homepage")
    public void userOpensGreenkartHomepage() {
        driver = utilities.DriverFactory.open("chrome");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("user does a search and gets the product name")
    public void userDoesASearch() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//*[@class='search-keyword']"));
        search.sendKeys("Tomato");
        Thread.sleep(1000);
        confirmation = driver.findElement(By.xpath("//h4[@class ='product-name']")).getText().split("-")[0].trim();
        System.out.println(confirmation);
    }


    @And("user goes to Top Deals and does a search {string}")
    public void userGetsProductNameAndGoesToTopDeals(String searchKeyword) throws InterruptedException {
        WebElement topDeals = driver.findElement(By.linkText("Top Deals"));
        topDeals.click();
        Set<String> window= driver.getWindowHandles();
        Iterator<String> itr=window.iterator();
        String parentWindow = itr.next();
        String childWindow1 = itr.next();
        driver.switchTo().window(childWindow1);
        WebElement search = driver.findElement(By.id("search-field"));
        search.sendKeys(searchKeyword);
        Thread.sleep(1000);
        topDealsSearch=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//td[1]")).getText();
        System.out.println(topDealsSearch);
    }


    @Then("user is checks if Top deals is available for searched product")
    public void userIsChecksIfTopDealsIsAvailableForSearchedProduct() {
        Assert.assertEquals(confirmation, topDealsSearch);
    }


//
//    @When("user does many search")
//    public void userDoesManySearch(List<String> searchText) throws InterruptedException {
//        int size = searchText.size();
//        for (int i = 0; i < size; i++) {
//            WebElement search = driver.findElement(By.xpath("//*[@class='search-keyword']"));
//            search.sendKeys(searchText.get(i));
//            search.sendKeys(Keys.ENTER);
//            search.clear();
//
//        }
//
//    }


}
