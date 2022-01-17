package stepImplementation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCart {

    WebDriver driver;
    @Given("^user is in home page$")
    public void user_is_in_home_page()
    {
        driver=utilities.DriverFactory.open("chrome");
        driver.get("https://www.edgewordstraining.co.uk/demo-site/my-account/");
    }

    @When("user logs in")
    public void userLogsIn(DataTable data) {
        List<List<String>> credentials = data.asLists();
        WebElement username = driver.findElement(By.xpath("//*[@class='woocommerce-form woocommerce-form-login login']/p[1]/input[1]"));
        username.sendKeys(credentials.get(0).get(0));
        WebElement password = driver.findElement(By.xpath("//*[@class='woocommerce-form woocommerce-form-login login']/p[2]/input[1]"));
        password.sendKeys(credentials.get(0).get(1));
        WebElement login = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", login);
    }

    @When("user types in search bar and clicks enter {string}")
    public void userTypesInSearchBarAndClicksEnter(String searchText) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.xpath("//*[@id='woocommerce-product-search-field-0']"));
        search.sendKeys(searchText);
        search.sendKeys(Keys.ENTER);
        System.out.println("Hello");

    }
    
    @Then("^user should be taken to search result page$")
    public void user_should_be_taken_to_search_result_page()
    {
//        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//        String confirmation = driver.findElement(By.xpath("//h1[contains(text(),'Search results')]")).getText();
//        System.out.println(confirmation);
        driver.quit();
    }


    @When("user searches {string}")
    public void userSearches(String text) {
        WebElement search = driver.findElement(By.xpath("//*[@id='woocommerce-product-search-field-0']"));
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);
        System.out.println("Hello");

    }

    @When("user enters wrong credentials")
    public void userEntersWrongCredentials(DataTable data) {
        List<List<String>> credentials = data.asLists();
        WebElement username = driver.findElement(By.xpath("//*[@class='woocommerce-form woocommerce-form-login login']/p[1]/input[1]"));
        username.sendKeys(credentials.get(0).get(0));
        WebElement password = driver.findElement(By.xpath("//*[@class='woocommerce-form woocommerce-form-login login']/p[2]/input[1]"));
        password.sendKeys(credentials.get(0).get(1));
        WebElement login = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", login);
        System.out.println("Hello");
    }

    @Then("user shouldn't be logged in")
    public void userShouldnTBeLoggedIn() {
        WebElement error = driver.findElement(By.xpath(" //*[@class='woocommerce-error']//li[1]"));
        System.out.println( error.getText());
        driver.quit();
    }
}
