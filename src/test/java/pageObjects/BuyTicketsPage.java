package pageObjects;

import helpers.DataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuyTicketsPage {
    private static WebDriver driver;

    private static final By timeTableAndPlacesSectionPlaceFromInput = By.xpath("//form[@name = 'searchTimetable']//input[@ng-model = 'depart']");
    private static final By timeTableAndPlacesSectionPlaceToInput = By.xpath("//form[@name = 'searchTimetable']//input[@ng-model = 'arrival']");
    private static final By timeTableAndPlacesSectionFromTable = By.xpath("//form[@name = 'searchTimetable']//table[@id= 'datepicker-first_table']");
    private static final By timeTableAndPlacesSectionToTable = By.xpath("//form[@name = 'searchTimetable']//table[@id= 'datepicker-second_table']");
    private static final By timeTableAndPlacesSectionSubmitButton = By.xpath("//form[@name = 'searchTimetable']//input[@type= 'submit']");
    private static final By timeTableAndPlacesSectionComfort1Button = By.xpath("//form[@name = 'searchTimetable']//label[@id = 'option1Label']");
    private static final By timeTableAndPlacesSectionComfort2Button = By.xpath("//form[@name = 'searchTimetable']//label[@id = 'option2Label']");
    private static final By timeTableAndPlacesSectionPassengerCountSection = By.xpath("//form[@name = 'searchTimetable']//div[contains(@class, 'selectitem') and button[@data-id='nr_passageiros']]");
    private static final By visibleTypeAheadItem = By.xpath("//ul[@class= 'typeahead dropdown-menu']");
    private static final By selectedDateItem = By.xpath("//div[contains(@class, 'picker__day--infocus picker__day--selected')]");
    private static final By firstDatePickerInput = By.xpath("//input[@id = 'datepicker-first']");
    private static final By secondDatePickerInput = By.xpath("//input[@id = 'datepicker-second']");

    public BuyTicketsPage(WebDriver driver) {
        this.driver = driver;
    }

    private BuyTicketsPage clickVisibleListItemByName(String listItemName) {
        driver.findElement(visibleTypeAheadItem).findElement(By.xpath("//strong[normalize-space(text()) = '" + listItemName + "']")).click();
        return this;
    }

    private BuyTicketsPage clickOnSelectedDate() {
        driver.findElement(selectedDateItem).click();
        return this;
    }

    public BuyTicketsPage fillInFromPlace(String fromPlaceName) {
        driver.findElement(timeTableAndPlacesSectionPlaceFromInput).clear();
        driver.findElement(timeTableAndPlacesSectionPlaceFromInput).sendKeys(fromPlaceName);
        clickVisibleListItemByName(fromPlaceName);
        DataManager.setData("_fromPlace", fromPlaceName);
        return this;
    }

    public BuyTicketsPage fillInToPlace(String toPlaceName) {
        driver.findElement(timeTableAndPlacesSectionPlaceToInput).clear();
        driver.findElement(timeTableAndPlacesSectionPlaceToInput).sendKeys(toPlaceName);
        clickVisibleListItemByName(toPlaceName);
        DataManager.setData("_toPlace", toPlaceName);
        return this;
    }

    public BuyTicketsPage selectFromDate(String fromDate) {
        driver.findElement(firstDatePickerInput).click();
        driver.findElement(timeTableAndPlacesSectionFromTable).findElement(By.xpath(".//td//div[normalize-space(text()) = '" + fromDate + "']")).click();
        DataManager.setData("_fromDate", driver.findElement(firstDatePickerInput).getText());
        return this;
    }

    public BuyTicketsPage selectToDate(String toDate) {
        driver.findElement(secondDatePickerInput).click();
        driver.findElement(timeTableAndPlacesSectionToTable).findElement(By.xpath(".//td//div[normalize-space(text()) = '" + toDate + "']")).click();
        DataManager.setData("_toDate", driver.findElement(secondDatePickerInput).getText());
        return this;
    }

    public BuyTicketsPage selectPassengerCount(String passengers) {
        driver.findElement(timeTableAndPlacesSectionPassengerCountSection).findElement(By.xpath(".//button")).click();
        driver.findElement(timeTableAndPlacesSectionPassengerCountSection).findElement(By.xpath(".//li//span[normalize-space(text()) = '" + passengers + "']")).click();
        DataManager.setData("_passengers", passengers);
        return this;
    }

    public BuyTicketsPage clickButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("submit")) {
            driver.findElement(timeTableAndPlacesSectionSubmitButton).click();
        } else if (buttonName.toLowerCase().contains("first class")) {
            driver.findElement(timeTableAndPlacesSectionComfort1Button).click();
            DataManager.setData("_seatClass", "first class");
        } else if (buttonName.equalsIgnoreCase("passenger count")) {
            driver.findElement(timeTableAndPlacesSectionPassengerCountSection).click();
        }
        return this;
    }

    //comfort class passenger count
    public String getElementValue(String elementName) throws Exception {
        if (elementName.equals("from place")) {
            return driver.findElement(timeTableAndPlacesSectionPlaceFromInput).getAttribute("value");
        } else if (elementName.equals("to place")) {
            return driver.findElement(timeTableAndPlacesSectionPlaceToInput).getAttribute("value");
        } else if (elementName.equals("from date")) {
            return driver.findElement(firstDatePickerInput).getAttribute("value");
        } else if (elementName.equals("to date")) {
            return driver.findElement(secondDatePickerInput).getAttribute("value");
        } else if (elementName.equals("seat class")) {
            if (driver.findElement(timeTableAndPlacesSectionComfort1Button).findElement(By.xpath(".//input")).isSelected()) {
                return "first class";
            } else if (driver.findElement(timeTableAndPlacesSectionComfort2Button).findElement(By.xpath(".//input")).isSelected()) {
                return "second class";
            } else {
                throw new Exception("no options selected");
            }
        } else if (elementName.equals("passenger count")) {
            return driver.findElement(timeTableAndPlacesSectionPassengerCountSection).getText();
        } else {
            throw new Exception("field not supported");
        }
    }
}
