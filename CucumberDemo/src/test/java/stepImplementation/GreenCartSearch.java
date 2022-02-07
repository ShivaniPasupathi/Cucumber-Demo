package stepImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageObject.GreenCartSearchPO;
import utilities.DriverFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GreenCartSearch {
    public DriverFactory driverFactory;
    public String confirmation;
    public Set<String> products = new HashSet<String>();

    public GreenCartSearch(DriverFactory driverFactory) // Dependency Injection driver and confirmation can be accessed by any class now.
    {
        this.driverFactory=driverFactory;
    }



    @Given("user opens Greenkart Homepage")
    public void userOpensGreenkartHomepage() {
        driverFactory.driver = utilities.DriverFactory.open("chrome");
        driverFactory.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("user does a search and gets the product name")
    public void userDoesASearch() throws InterruptedException {
        GreenCartSearchPO greenCartSearchPO = new GreenCartSearchPO(driverFactory.driver);
        greenCartSearchPO.searchItem("Tomato");
        Thread.sleep(1000);
        driverFactory.confirmation = driverFactory.driver.findElement(By.xpath("//h4[@class ='product-name']")).getText().split("-")[0].trim();
        System.out.println(confirmation);
    }


    @When("user does many search")
    public void userDoesManySearch(List<String> searchText) throws InterruptedException {
        int size = searchText.size();
        for (int i = 0; i < size; i++) {
            WebElement search = driverFactory.driver.findElement(By.xpath("//*[@class='search-keyword']"));
            search.sendKeys(searchText.get(i));
            search.sendKeys(Keys.ENTER);
            Thread.sleep(1000);
            products.add(driverFactory.confirmation = driverFactory.driver.findElement(By.xpath("//h4[@class ='product-name']")).getText().split("-")[0].trim());
            search.clear();

        }

    }


    @And("user gets results")
    public void userGetsResults() {
        for(String product:products)
        {
            System.out.println(product);
        }
    }
}
