package suite;

import core.BaseTest;
import core.LoggerManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;

public class MySuite extends BaseTest {

    @Test(retryAnalyzer = core.retry.RetryAnalyzer.class)
    public void testHomePage() {
        // Usa l'URL di base definito in BaseTest
        driver.get(getBaseUrl());
        LoggerManager.info("Titolo della pagina: " + driver.getTitle());
        Homepage homepage = new Homepage(getDriver());

        LoggerManager.info("Verifica che il pulsante \"Accetta Cookies\" sia visibile");
        Assert.assertTrue(homepage.isElementVisible(homepage.getAcceptCookiesButton()), "Il pulsante 'Accetta Cookies' non è visibile.");
    }

    @Test(retryAnalyzer = core.retry.RetryAnalyzer.class)
    public void testExample() {
        // Usa l'URL di base per la pagina di login
        driver.get(getBaseUrl());
        LoggerManager.info("Titolo della pagina: " + driver.getTitle());
        Homepage homepage = new Homepage(getDriver());

        LoggerManager.info("Verifica che il pulsante \"Accetta Cookies\" sia visibile");
        Assert.assertTrue(homepage.isElementVisible(homepage.getAcceptCookiesButton()), "Il pulsante 'Accetta Cookies' non è visibile.");
        LoggerManager.info("Click su \"Accetta Cookies\"");
        homepage.clickAcceptCookies();

        LoggerManager.info("Verifica che il pulsante \"Non Adesso\" sia visibile");
        Assert.assertTrue(homepage.isElementVisible(homepage.getNotNowButton()), "Il pulsante 'Non Adesso' non è visibile.");
        LoggerManager.info("Click su \"Non adesso\"");
        homepage.clickNotNow();
    }
}
