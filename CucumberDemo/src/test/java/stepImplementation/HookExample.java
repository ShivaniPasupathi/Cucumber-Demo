package stepImplementation;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookExample {
    @Before("@mandatoryTest")
    public void beforeMandatoryTest()
    {
        System.out.println("Before");
    }

    @After("@mandatoryTest")
    public void afterMandatoryTest()
    {
        System.out.println("after");
    }
}
