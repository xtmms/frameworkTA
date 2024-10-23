package navigation;

import core.LoggerManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Homepage;

public class Navigation {

    private WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Apro la HomePage")
    public void openHomePage(String baseUrl) {
        driver.get(baseUrl);
    }

    @Step("Verifico il titolo della HomePage")
    public void verifyHomePageTitle() {
        LoggerManager.info("Titolo della pagina: " + driver.getTitle());
    }

    @Step("Verifico che il pulsante 'Accetta Cookies' sia visibile")
    public void verifyAcceptCookiesButtonIsVisible() {
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isElementVisible(homepage.getAcceptCookiesButton()), "Il pulsante 'Accetta Cookies' non è visibile.");
    }

    @Step("Verifico e clicco sul pulsante 'Accetta Cookies'")
    public void verifyAndClickAcceptCookiesButton() {
        Homepage homepage = new Homepage(driver);
        LoggerManager.info("Verifica che il pulsante 'Accetta Cookies' sia visibile");
        Assert.assertTrue(homepage.isElementVisible(homepage.getAcceptCookiesButton()), "Il pulsante 'Accetta Cookies' non è visibile.");
        LoggerManager.info("Click su 'Accetta Cookies'");
        homepage.clickAcceptCookies();
    }

    @Step("Verifico e clicco sul pulsante 'Non Adesso'")
    public void verifyAndClickNotNowButton() {
        Homepage homepage = new Homepage(driver);
        LoggerManager.info("Verifica che il pulsante 'Non Adesso' sia visibile");
        Assert.assertTrue(homepage.isElementVisible(homepage.getNotNowButton()), "Il pulsante 'Non Adesso' non è visibile.");
        LoggerManager.info("Click su 'Non Adesso'");
        homepage.clickNotNow();
    }
}

