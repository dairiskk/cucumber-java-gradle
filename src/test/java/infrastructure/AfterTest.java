package infrastructure;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.time.LocalDateTime;

public class AfterTest extends DriverManager {
    private WebDriver driver;

    public AfterTest() {
        this.driver = getDriver();
    }

    @After
    public void quitDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            saveScreenshotsForScenario(scenario);
        }
        this.driver.close();
        this.driver.quit();
    }

    private void saveScreenshotsForScenario(final Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", LocalDateTime.now().toString());

    }
}
