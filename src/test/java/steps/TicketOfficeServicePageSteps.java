package steps;

import infrastructure.DriverManager;
import io.cucumber.java.en.Then;
import pageObjects.TicketOfficeServicePage;

public class TicketOfficeServicePageSteps extends DriverManager {
    @Then("I validate outward table in service step equals {string}")
    public void iValidateOutwardTableInServiceStepEquals(String headerName) {
        TicketOfficeServicePage ticketOfficeServicePage = new TicketOfficeServicePage(getDriver());
        ticketOfficeServicePage.validateOutwardTableHeader(headerName);
    }

    @Then("I validate inward table in service step equals {string}")
    public void iValidateInwardTableInServiceStepEquals(String headerName) {
        TicketOfficeServicePage ticketOfficeServicePage = new TicketOfficeServicePage(getDriver());
        ticketOfficeServicePage.validateInwardTableHeader(headerName);
    }

    @Then("I press {string} in service page")
    public void iPressButton(String buttonName) throws Exception {
        TicketOfficeServicePage ticketOfficeServicePage = new TicketOfficeServicePage(getDriver());
        if (buttonName.toLowerCase().contains("continue")) {
            ticketOfficeServicePage.pressContinueButton();
        } else if (buttonName.toLowerCase().contains("agree with terms")) {
            ticketOfficeServicePage.pressAgreeWithTerms();
        } else {
            throw new Exception("button " + buttonName + "not supported");
        }
    }

    @Then("I select option number {string} in {string} table")
    public void iSelectOptionNumberInOutwardTable(String number, String tableName) throws Exception {
        TicketOfficeServicePage ticketOfficeServicePage = new TicketOfficeServicePage(getDriver());
        if (tableName.equalsIgnoreCase("outward")) {
            ticketOfficeServicePage.selectOutwardTableOptionByNumber(number);
        } else if (tableName.equalsIgnoreCase("inward")) {
            ticketOfficeServicePage.selectInwardTableOptionByNumber(number);
        } else {
            throw new Exception("table name " + tableName + "not supported");
        }

    }
}
