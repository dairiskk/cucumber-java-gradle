package pageObjects;

import infrastructure.BeforeTest;
import infrastructure.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends DriverManager {
    WebElement timeTableAndPlacesSection = getDriver().findElement(By.xpath("//form[@name = 'searchTimetable']"));
    WebElement timeTableAndPlacesSectionPlaceFromInput = timeTableAndPlacesSection.findElement(By.xpath("//input[@name = 'depart']"));
    WebElement timeTableAndPlacesSectionPlaceToInput = timeTableAndPlacesSection.findElement(By.xpath("//input[@name = 'arrival']"));
    WebElement timeTableAndPlacesSectionFromDate = timeTableAndPlacesSection.findElement(By.xpath("//input[@id= 'datepicker-first']"));
    WebElement timeTableAndPlacesSectionToDate = timeTableAndPlacesSection.findElement(By.xpath("//input[@id= 'datepicker-second']"));
    WebElement timeTableAndPlacesSectionSubmitButton = timeTableAndPlacesSection.findElement(By.xpath("//input[@type= 'submit']"));



}
