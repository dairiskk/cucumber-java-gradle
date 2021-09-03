package steps;

import infrastructure.DriverManager;
import io.cucumber.java.en.Given;

public class HomePageSteps extends DriverManager {
    @Given("I navigate to {string}")
    public void iNavigateTo(String pageUrl) {
        getDriver().get(pageUrl);
        System.out.println();
    }
}
