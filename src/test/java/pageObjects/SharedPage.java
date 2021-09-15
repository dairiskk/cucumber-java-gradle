package pageObjects;

import infrastructure.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SharedPage {

    private static WebDriver driver;

    public SharedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
