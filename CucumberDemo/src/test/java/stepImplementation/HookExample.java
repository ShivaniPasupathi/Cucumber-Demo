package stepImplementation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.messages.Messages;
import org.openqa.selenium.WebDriver;
import utilities.UtilitySetUp;

import java.io.IOException;

public class HookExample {
   public UtilitySetUp utilitySetUp;
//    @Before("@mandatoryTest")
//    public void beforeMandatoryTest()
//    {
//        System.out.println("Before");
//    }
//
//    @After("@mandatoryTest")
//    public void afterMandatoryTest()
//    {
//        System.out.println("after");
//    }

    public HookExample(UtilitySetUp utilitySetUp)
    {
        this.utilitySetUp=utilitySetUp;
    }

    @After
    public void afterScenariosExecution() throws IOException {
        utilitySetUp.driverFactory.open().quit();
    }
}
