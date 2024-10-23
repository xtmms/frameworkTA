package module;

import core.interfaces.IWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ScreenshotUtils;
import utils.WaitUtils;

public class WebPage implements IWebPage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    // Costruttore
    public WebPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(this.driver);  // Inizializza WaitUtils
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    // Metodo per cliccare su un elemento
    public void clickElement(WebElement element) {
        WebElement clickableElement = waitUtils.waitForElementToBeClickable(element);
        clickableElement.click();
    }

    // Metodo per inserire testo in un campo di input
    public void enterText(WebElement element, String text) {
        WebElement visibleElement = waitUtils.waitForElementToBeVisible(element);
        visibleElement.clear();
        visibleElement.sendKeys(text);
    }

    // Metodo per ottenere il testo di un elemento
    public String getElementText(WebElement element) {
        WebElement visibleElement = waitUtils.waitForElementToBeVisible(element);
        return visibleElement.getText();
    }

    // Metodo per verificare se un elemento è visibile
    public boolean isElementVisible(WebElement element) {
        try {
            WebElement visibleElement = waitUtils.waitForElementToBeVisible(element);
            return visibleElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Metodo per fare uno screenshot
    public void takeScreenshot(String screenshotPath) {
        ScreenshotUtils.captureScreenshot(driver, screenshotPath);
    }
}
