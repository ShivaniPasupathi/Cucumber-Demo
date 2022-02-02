package stepImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GreenCartSearch {
    WebDriver driver;

    @Given("user opens Greenkart Homepage")
    public void userOpensGreenkartHomepage() {
        driver = utilities.DriverFactory.open("chrome");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("user does a search and gets the product name")
    public void userDoesASearch() {
        WebElement search = driver.findElement(By.xpath("//*[@class='search-keyword']"));
        search.sendKeys("Tomato");
        WebElement confirmation = driver.findElement(By.xpath("//h4[@class ='product-name']"));
        System.out.println(confirmation.getText().split("-")[0]);
    }


    @And("user goes to Top Deals and does a search")
    public void userGetsProductNameAndGoesToTopDeals() {
        WebElement topDeals = driver.findElement(By.linkText("Top Deals"));
        topDeals.click();
        Set<String> window= driver.getWindowHandles();
        Iterator<String> itr=window.iterator();
        String parentWindow = itr.next();
        String childWindow1 = itr.next();
        driver.switchTo().window(childWindow1);
    }

    @Then("user is checks if Top deals is available")
    public void userIsChecksIfTopDealsIsAvailable() {
    }

    @When("user does many search")
    public void userDoesManySearch(List<String> searchText) throws InterruptedException {
        int size = searchText.size();
        for (int i = 0; i < size; i++) {
            WebElement search = driver.findElement(By.xpath("//*[@class='search-keyword']"));
            search.sendKeys(searchText.get(i));
            search.sendKeys(Keys.ENTER);
            search.clear();
        }

    }


}
