package pageObjects;

import infrastructure.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage extends DriverManager {
    private static WebDriver driver;

    public static final By headerSection = By.xpath("//div[@class = 'header']");
    public static final By englishLanguageLabel = By.xpath("//div[@class = 'header']//ul[@class = 'user-nav']//a[normalize-space(text()) = 'EN']");
    public static final By portugueseLanguageLabel = By.xpath("//div[@class = 'header']//ul[@class = 'user-nav']//a[normalize-space(text()) = 'PT']");
    public static final By mainMenuSection = By.xpath("//div[@class = 'menu-main']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectNavigationOptionFromMainMenu(String nameOfMenu) {
        if (nameOfMenu.toLowerCase().equals("buy tickets")) {
            driver.findElement(mainMenuSection).findElement(By.xpath(".//span[@class = 'title-menu' and normalize-space(text()) = 'Tickets']")).click();
        }
    }

    public void selectLanguage(String language) {
        if (language.toLowerCase().equals("english")) {
            driver.findElement(englishLanguageLabel).click();
        } else if (language.toLowerCase().equals("portuguese")) {
            driver.findElement(portugueseLanguageLabel).click();
        }
    }


}
