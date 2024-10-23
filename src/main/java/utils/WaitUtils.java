package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.ConfigManager;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private int timeout;

    public WaitUtils(WebDriver driver) {
        this.timeout = ConfigManager.getIntProperty("timeout");
        this.driver = driver;
    }

    // Attende che un elemento sia visibile utilizzando il timeout di default
    public WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Attende che un elemento sia cliccabile utilizzando il timeout di default
    public WebElement waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Attende che un elemento scompaia utilizzando il timeout di default
    public boolean waitForElementToDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}


