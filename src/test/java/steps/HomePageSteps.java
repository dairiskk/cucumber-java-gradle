package steps;

import helpers.DateHelper;
import infrastructure.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class HomePageSteps extends DriverManager {
    @Given("I navigate to {string}")
    public void iNavigateTo(String pageUrl) {
        getDriver().get(pageUrl);
    }

    @Then("I search the train from {string} to {string}")
    public void iSearchTheTrainFromTo(String fromPlace, String toPlace) {
        HomePage.timeTableAndPlacesSectionPlaceFromInput.sendKeys(fromPlace);
        HomePage.timeTableAndPlacesSectionPlaceToInput.sendKeys(toPlace);
    }

    @Then("I select towards date that is {int} {string} from today")
    public void iSelectTowardsDateThatIsFromToday(int time, String timeUnit) throws Exception {
        if (timeUnit.toLowerCase().equals("days")) {
            HomePage.timeTableAndPlacesSectionFromDate.sendKeys(DateHelper.addDaysToDate(time, Calendar.DATE));
        } else if (timeUnit.toLowerCase().equals("months")) {
            HomePage.timeTableAndPlacesSectionFromDate.sendKeys(DateHelper.addDaysToDate(time, Calendar.MONTH));
        } else {
            throw new Exception("date format " + timeUnit + " not supported");
        }
    }

    @Then("I select backwards date that is {int} {string} from today")
    public void iSelectBackwardsDateThatIsFromToday(int time, String timeUnit) throws Exception {
        if (timeUnit.toLowerCase().equals("days")) {
            HomePage.timeTableAndPlacesSectionToDate.sendKeys(DateHelper.addDaysToDate(time, Calendar.DATE));
        } else if (timeUnit.toLowerCase().equals("months")) {
            HomePage.timeTableAndPlacesSectionToDate.sendKeys(DateHelper.addDaysToDate(time, Calendar.MONTH));
        } else {
            throw new Exception("date format " + timeUnit + " not supported");
        }
    }
}
