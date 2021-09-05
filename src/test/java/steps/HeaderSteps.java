package steps;

import io.cucumber.java.en.Then;
import pageObjects.HeaderPageObjects;

public class HeaderSteps {
    @Then("I switch language to {string}")
    public void iSwitchLanguageTo(String language) {
        if (language.toLowerCase().equals("en")) {
            HeaderPageObjects.englishLanguageLabel.click();
        } else if (language.toLowerCase().equals("pt")) {
            HeaderPageObjects.portugueseLanguageLabel.click();
        }
    }
}
