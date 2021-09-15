package steps;

import helpers.GeneralHelpers;
import infrastructure.DriverManager;
import io.cucumber.java.en.Then;
import pageObjects.TicketOfficeOptionsPage;

import java.util.List;
import java.util.Map;

public class TicketOfficeOptionsSteps extends DriverManager {
    @Then("I validate element visibility in Ticket Office Options section")
    public void iValidateThatElementsArePresentInTicketOfficeOptionsSection(Map<String, String> map) throws Exception {
        TicketOfficeOptionsPage ticketOfficeOptionsPage = new TicketOfficeOptionsPage(getDriver());
        for (String field : map.keySet()) {
            switch (field) {
                case "email":
                case "password":
                    ticketOfficeOptionsPage.validateVisibilityOfElement(field, GeneralHelpers.isStringTrue(map.get(field)));
                    break;
                default:
                    throw new Exception("field " + field + " not supported");
            }
        }
    }

    @Then("I click on {string} in Options page")
    public void iClickOnInOptionsPage(String element) throws Exception {
        TicketOfficeOptionsPage ticketOfficeOptionsPage = new TicketOfficeOptionsPage(getDriver());
        if (element.toLowerCase().contains("cancel")) {
            ticketOfficeOptionsPage.pressCancelButton();
        } else {
            throw new Exception("element " + element + " not supported");
        }
    }
}
