package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TicketOfficeServicePage {
    private static WebDriver driver;

    private static final By outwardTable = By.xpath("//span[normalize-space(text()) = 'OUTWARD']//ancestor::div[@class='row']");
    private static final By inwardTable = By.xpath("//span[normalize-space(text()) = 'INWARD']//ancestor::div[@class='row']");
    private static final By continueButton = By.xpath("//input[@id='buttonNext']");
    private static final By agreeWithTermsCheckbox = By.xpath("//input[@id='travelTerms']");

    public TicketOfficeServicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOutwardTableHeader(String expectedHearerName) {
        Assert.assertEquals("outward data table header is incorrect", expectedHearerName, driver.findElement(outwardTable).findElement(By.xpath(".//div[@class = 'results']")).getText());
    }

    public void validateInwardTableHeader(String expectedHearerName) {
        Assert.assertEquals("inward data table header is incorrect", expectedHearerName, driver.findElement(inwardTable).findElement(By.xpath(".//div[@class = 'results']")).getText());
    }

    public void pressContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void pressAgreeWithTerms() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", driver.findElement(agreeWithTermsCheckbox));
    }

    public void selectOutwardTableOptionByNumber(String number) {
        driver.findElement(outwardTable).findElement(By.xpath(".//table[contains(@class, 'table-search-results')]//tr[" + Integer.parseInt(number) + "]//td[1]")).click();
    }

    public void selectInwardTableOptionByNumber(String number) {
        driver.findElement(inwardTable).findElement(By.xpath(".//table[contains(@class, 'table-search-results')]//tr[" + Integer.parseInt(number) + "]//td[1]")).click();
    }
}
