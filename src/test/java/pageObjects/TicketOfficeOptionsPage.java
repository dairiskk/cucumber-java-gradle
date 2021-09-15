package pageObjects;

import infrastructure.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketOfficeOptionsPage {
    private static WebDriver driver;
    private static final By cancelButton = By.xpath("//input[@id= 'exitButton']");
    private static final By emailInput = By.xpath("//input[@id= 'username']");
    private static final By passwordInput = By.xpath("//input[@id= 'password']");


    public TicketOfficeOptionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public void validateVisibilityOfElement(String element, boolean isVisible) throws Exception {
        if (element.equalsIgnoreCase("email")) {
            Assert.assertEquals(isVisible, driver.findElement(emailInput).isDisplayed());

        } else if (element.equalsIgnoreCase("password")) {
            Assert.assertEquals(isVisible, driver.findElement(passwordInput).isDisplayed());
        } else {
            throw new Exception("not supported field");
        }
    }

}
