package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class SampleTest {
    @Before()
    public void setupDriver() {
        Driver.getChromeDriver();
    }

    @After()
    public void quitDriver() {
        Driver.closeDriver();
    }
}
