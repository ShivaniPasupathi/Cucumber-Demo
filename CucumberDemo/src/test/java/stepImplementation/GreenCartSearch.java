package stepImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import pageObject.GreenCartSearchPO;
import utilities.DriverFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GreenCartSearch {
    public DriverFactory driverFactory;
    public String confirmation;
    public Set<String> products = new HashSet<String>();


    public GreenCartSearch(DriverFactory driverFactory) // Dependency Injection -> driver and confirmation can be accessed by any class now.
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
        GreenCartSearchPO greenCartSearchPO = driverFactory.pageObjectManager.getGreenCartPage();
        greenCartSearchPO.searchItem("Tomato");
        Thread.sleep(1000);
        driverFactory.confirmation = greenCartSearchPO.getProductName();
        System.out.println(confirmation);
    }

    @When("user does many search")
    public void userDoesManySearch(List<String> searchText) throws InterruptedException {
        GreenCartSearchPO greenCartSearchPO = driverFactory.pageObjectManager.greenCartSearchPO;
        int size = searchText.size();
        for (int i = 0; i < size; i++) {
            greenCartSearchPO.searchItem(searchText.get(i));
            Thread.sleep(1000);
            products.add(driverFactory.confirmation = greenCartSearchPO.getProductName());
            greenCartSearchPO.clearSearch();
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
