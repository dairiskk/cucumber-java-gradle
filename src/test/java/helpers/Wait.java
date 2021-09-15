package helpers;

import infrastructure.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;


public class Wait {

    public static void waitForUrlToChange(String expected) {
        createWait().until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().contains(expected);
            }
        });
    }

    public static FluentWait<WebDriver> createWait() {
        return new FluentWait<WebDriver>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }
}
