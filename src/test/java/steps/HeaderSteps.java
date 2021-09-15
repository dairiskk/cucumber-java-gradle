package steps;

import infrastructure.DriverManager;
import io.cucumber.java.en.Then;
import pageObjects.HeaderPage;

public class HeaderSteps extends DriverManager {
    @Then("I switch language to {string}")
    public void iSwitchLanguageTo(String language) throws Exception {
        HeaderPage headerPage = new HeaderPage(getDriver());
        if (language.equalsIgnoreCase("english")) {
            headerPage.selectLanguage(language);
        } else if (language.equalsIgnoreCase("portuguese")) {
            headerPage.selectLanguage(language);
        } else {
            throw new Exception("language " + language + " not supported");
        }
    }

    @Then("I click on {string} navigation menu")
    public void iClickOnNavigationMenu(String navOption) throws Exception {
        HeaderPage headerPage = new HeaderPage(getDriver());
        headerPage.selectNavigationOptionFromMainMenu(navOption);
    }
}
