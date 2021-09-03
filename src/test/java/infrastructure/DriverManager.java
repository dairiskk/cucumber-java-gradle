package infrastructure;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    public static void setDriver(WebDriver currentDriver) {
        driver = currentDriver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
