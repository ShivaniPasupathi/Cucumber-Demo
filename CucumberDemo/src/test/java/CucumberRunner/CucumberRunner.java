package CucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/GreenCart.feature", glue = "stepImplementation", stepNotifications = true,
        tags = "", plugin = {"pretty", "html:target/CucumberResults.html",
        "json:target/CucumberResults.json"})
public class CucumberRunner {
}

