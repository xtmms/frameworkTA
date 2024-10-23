package pages;

import module.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import core.ConfigManager;

public class Homepage extends WebPage {
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    // Locator per il pulsante "Accetta Cookies"
    @FindBy(xpath = "//button[contains(text(), 'Accetta') or contains(text(), 'Accetta Cookies')]")
    private WebElement acceptCookiesButton;

    // Locator per il pulsante "Non Adesso" sul banner superiore
    @FindBy(xpath = "//a[contains(text(), 'Non adesso')]")
    private WebElement notNowButton;

    // Costruttore
    public Homepage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        int timeout = ConfigManager.getIntProperty("timeout");
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }

    public void setAcceptCookiesButton(WebElement acceptCookiesButton) {
        this.acceptCookiesButton = acceptCookiesButton;
    }

    public WebElement getNotNowButton() {
        return notNowButton;
    }

    public void setNotNowButton(WebElement notNowButton) {
        this.notNowButton = notNowButton;
    }

    // Metodo per cliccare sul pulsante "Accetta Cookies"
    public void clickAcceptCookies() {
        waitUtils.waitForElementToBeClickable(acceptCookiesButton).click();
    }

    // Metodo per cliccare sul pulsante "Non Adesso"
    public void clickNotNow() {
        waitUtils.waitForElementToBeClickable(notNowButton).click();
    }

    // Implementazione del metodo isLoaded per la verifica del caricamento della pagina
    @Override
    public boolean isLoaded() {
        return waitUtils.waitForElementToBeVisible(acceptCookiesButton) != null;
    }
}

