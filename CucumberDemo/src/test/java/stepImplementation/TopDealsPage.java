package stepImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObject.GreenCartSearchPO;
import pageObject.PageObjectManager;
import pageObject.TopDealsPagePO;
import utilities.UtilitySetUp;


public class TopDealsPage {
    public UtilitySetUp utilitySetUp;
    public String topDealsSearch;
  //  public PageObjectManager pageObjectManager;
    public TopDealsPage(UtilitySetUp utilitySetUp)
    {
        this.utilitySetUp=utilitySetUp;
    }

    @And("user goes to Top Deals and does a search {string}")
    public void userGetsProductNameAndGoesToTopDeals(String searchKeyword) throws InterruptedException {
        switchWindow();
        TopDealsPagePO topDealsPagePO = utilitySetUp.pageObjectManager.getTopDealsPagePO();
        topDealsPagePO.searchItem(searchKeyword);
        Thread.sleep(1000);
        topDealsSearch=topDealsPagePO.getProductName();
        System.out.println(topDealsSearch);
    }


    @Then("user is checks if Top deals is available for searched product")
    public void userIsChecksIfTopDealsIsAvailableForSearchedProduct() {
        Assert.assertEquals(utilitySetUp.confirmation, topDealsSearch);
    }


    public void switchWindow() //loosely coupled -> single responsible principle and separation of concerns
    {
       // GreenCartSearchPO greenCartSearchPO = new GreenCartSearchPO(utilitySetUp.driver); // use factory design pattern instead of creating object each time inside a method.
      //  pageObjectManager = new PageObjectManager(utilitySetUp.driver); instead of creating object here create it in Utility set up class
        GreenCartSearchPO greenCartSearchPO= utilitySetUp.pageObjectManager.getGreenCartPage();
        greenCartSearchPO.clickTopDeals();
        utilitySetUp.genericUtils.switchWindow();

    }
}
