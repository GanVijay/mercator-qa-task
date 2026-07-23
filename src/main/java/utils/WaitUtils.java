package utils;

import drivers.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForVisible(WebElement element) {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitVisibleText(WebElement element) {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(driver -> {
                    String text = element.getText();
                    return text != null && !text.trim().isEmpty();
                });
    }

    public static void assertPageTitle(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(DriverFactory.getDriver().getTitle(), expectedTitle);
    }

}
