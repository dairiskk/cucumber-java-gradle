package steps;

import helpers.DataManager;
import helpers.DateHelper;
import infrastructure.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.BuyTicketsPage;

import java.util.Calendar;
import java.util.Map;

public class BuyTicketsSteps extends DriverManager {
    @Given("I navigate to {string}")
    public void iNavigateTo(String pageUrl) {
        getDriver().get(pageUrl);
    }

    @Then("I search the train from {string} to {string}")
    public void iSearchTheTrainFromTo(String fromPlace, String toPlace) {
        new BuyTicketsPage(getDriver())
                .fillInFromPlace(fromPlace)
                .fillInToPlace(toPlace);
    }

    @Then("I select towards date that is {int} {string} from today")
    public static void iSelectTowardsDateThatIsFromToday(int time, String timeUnit) throws Exception {
        BuyTicketsPage buyTicketsPage = new BuyTicketsPage(getDriver());
        if (timeUnit.equalsIgnoreCase("days")) {
            String fromDate = DateHelper.getPartOfDate(DateHelper.addDaysToDate(time, Calendar.DATE), Calendar.DATE);
            buyTicketsPage.selectFromDate(fromDate);
            DataManager.setData("_fromDate", buyTicketsPage.getElementValue("from date"));
        } else {
            throw new Exception("date format " + timeUnit + " not supported");
        }
    }

    @Then("I select backwards date that is {int} {string} from today")
    public void iSelectBackwardsDateThatIsFromToday(int time, String timeUnit) throws Exception {
        BuyTicketsPage buyTicketsPage = new BuyTicketsPage(getDriver());
        if (timeUnit.equalsIgnoreCase("days")) {
            String toDate = DateHelper.getPartOfDate(DateHelper.addDaysToDate(time, Calendar.DATE), Calendar.DATE);
            buyTicketsPage.selectToDate(toDate);
            DataManager.setData("_toDate", buyTicketsPage.getElementValue("to date"));
        } else {
            throw new Exception("date format " + timeUnit + " not supported");
        }
    }

    @Then("I click {string} button")
    public void iSaveTheseOptionByClickingOnButton(String buttonAme) throws Exception {
        BuyTicketsPage buyTicketsPage = new BuyTicketsPage(getDriver());
        if (buttonAme.equalsIgnoreCase("submit") || buttonAme.toLowerCase().contains("first class")) {
            buyTicketsPage.clickButton(buttonAme);
        } else {
            throw new Exception("button " + buttonAme + " not supported");
        }
    }

    @Then("I select {string} from the dropdown")
    public void iSelectFromTheDropdown(String passengers) {
        BuyTicketsPage buyTicketsPage = new BuyTicketsPage(getDriver());
        buyTicketsPage.selectPassengerCount(passengers);
    }

    @Then("I validate that buy tickets page contains correct values")
    public void iValidateThatBuyTicketsPageContainsCorrectValues(Map<String, String> map) throws Exception {
        BuyTicketsPage buyTicketsPage = new BuyTicketsPage(getDriver());
        for (String key : map.keySet()) {
            if (key.equals("passenger count")) {
                if (map.get(key).contains("_")) {
                    Assert.assertTrue(buyTicketsPage.getElementValue(key).contains(String.valueOf(DataManager.getData(map.get(key)))));
                } else {
                    Assert.assertTrue(buyTicketsPage.getElementValue(key).contains(String.valueOf(map.get(key))));
                }
            } else {
                if (map.get(key).contains("_")) {
                    Assert.assertEquals(DataManager.getData(map.get(key)), buyTicketsPage.getElementValue(key));
                } else {
                    Assert.assertEquals(map.get(key), buyTicketsPage.getElementValue(key));
                }
            }
        }
    }
}
