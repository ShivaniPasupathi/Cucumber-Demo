package stepImplementation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PractiseExample {
    WebDriver driver;


    @Then("user is taken to search result page")
    public void userIsTakenToSearchResultPage() {
    }

    @When("user does many search")
    public void userDoesManySearch(List<String> searchText) {
        int size = searchText.size();
        for (int i=0;i<size;i++) {
            WebElement search = driver.findElement(By.xpath("//*[@id='woocommerce-product-search-field-0']"));
            search.sendKeys(searchText.get(i));
            search.sendKeys(Keys.ENTER);
        }
        System.out.println("Hello");
    }

    @Given("user opens homepage")
    public void userOpensHomepage() {
        driver=utilities.DriverFactory.open("chrome");
        driver.get("https://www.edgewordstraining.co.uk/demo-site/my-account/");
    }
}
