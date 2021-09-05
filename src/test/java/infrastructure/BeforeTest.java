package infrastructure;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BeforeTest {
    private static WebDriver driver;

    @Before
    public void beforeEach() {
        String browser = System.getenv("BROWSER");

        if (System.getProperty("os.name").contains("Windows") || System.getProperty("os.name").contains("Mac")) {
            System.out.println("Web Driver in Windows/Mac Starting...");
            if ("firefox".equals(browser)) {
                System.out.println("Using Firefox");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                System.out.println("Using default browser - Chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("-window-size=1920,1080");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
        } else {
            System.out.println("Web Driver in Linux Starting...");
            if ("firefox".equals(browser)) {
                System.out.println("Using browser Firefox");
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.chrome.driver", "/usr/bin/firefox");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("-window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
            } else {
                System.out.println("Using default browser - Chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("-window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DriverManager.setDriver(driver);
    }
}
