package stepImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.GreenCartSearchPO;
import utilities.UtilitySetUp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GreenCartSearch {
    public UtilitySetUp utilitySetUp;
    public Set<String> products = new HashSet<>();


    public GreenCartSearch(UtilitySetUp utilitySetUp) // Dependency Injection -> driver and confirmation can be accessed by any class now.
    {
        this.utilitySetUp=utilitySetUp;
    }

    @Given("user opens Greenkart Homepage")
    public void userOpensGreenkartHomepage() {

    }
    @When("user does a search and gets the product name")
    public void userDoesASearch() throws InterruptedException {
        GreenCartSearchPO greenCartSearchPO = utilitySetUp.pageObjectManager.getGreenCartPage();
        greenCartSearchPO.searchItem("Tomato");
        Thread.sleep(1000);
        utilitySetUp.confirmation = greenCartSearchPO.getProductName();
        System.out.println(utilitySetUp.confirmation);
    }

    @When("user does many search")
    public void userDoesManySearch(List<String> searchText) throws InterruptedException {
        GreenCartSearchPO greenCartSearchPO = utilitySetUp.pageObjectManager.getGreenCartPage();
        int size = searchText.size();
        for (int i = 0; i < size; i++) {
            greenCartSearchPO.searchItem(searchText.get(i));
            Thread.sleep(1000);
            products.add(utilitySetUp.confirmation = greenCartSearchPO.getProductName());
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
