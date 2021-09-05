package pageObjects;

import infrastructure.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderPageObjects extends DriverManager {
    public static WebElement headerSection = getDriver().findElement(By.xpath("//div[@class = 'header']"));
    public static WebElement englishLanguageLabel = getDriver().findElement(By.xpath("//div[@class = 'header']//ul[@class = 'user-nav']//a[normalize-space(text()) = 'EN']"));
    public static WebElement portugueseLanguageLabel = getDriver().findElement(By.xpath("//div[@class = 'header']//ul[@class = 'user-nav']//a[normalize-space(text()) = 'PT']"));


}
