package steps;

import helpers.Wait;
import infrastructure.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.SharedPage;

public class SharedSteps extends DriverManager {
    @Then("I validate that currently {string} page is opened")
    public void iValidateThatCurrentlyPageIsOpened(String page) throws Exception {
        if (page.equalsIgnoreCase("buy tickets")) {
            Wait.waitForUrlToChange("/passageiros/en/buy-tickets");
        } else {
            throw new Exception("page " + page + " not supported");
        }
    }
}
