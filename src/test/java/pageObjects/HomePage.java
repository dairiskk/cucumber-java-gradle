package pageObjects;

import infrastructure.BeforeTest;
import infrastructure.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends DriverManager {
   public static WebElement timeTableAndPlacesSection = getDriver().findElement(By.xpath("//form[@name = 'searchTimetable']"));
    public static WebElement timeTableAndPlacesSectionPlaceFromInput = timeTableAndPlacesSection.findElement(By.xpath("//input[@name = 'depart']"));
    public static WebElement timeTableAndPlacesSectionPlaceToInput = timeTableAndPlacesSection.findElement(By.xpath("//input[@name = 'arrival']"));
    public static WebElement timeTableAndPlacesSectionFromDate = timeTableAndPlacesSection.findElement(By.xpath("//input[@id= 'datepicker-first']"));
    public static WebElement timeTableAndPlacesSectionToDate = timeTableAndPlacesSection.findElement(By.xpath("//input[@id= 'datepicker-second']"));
    public static WebElement timeTableAndPlacesSectionSubmitButton = timeTableAndPlacesSection.findElement(By.xpath("//input[@type= 'submit']"));
}
