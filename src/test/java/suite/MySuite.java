package suite;

import core.BaseTest;
import core.LoggerManager;
import core.AllureManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import navigation.Navigation;
import org.testng.annotations.Test;

@Feature("HomePage Feature")
public class MySuite extends BaseTest {

    @Test(retryAnalyzer = core.retry.RetryAnalyzer.class)
    @Description("Questo test verifica che atterriamo sulla HomePage di Zurich")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verifica caricamento della HomePage")
    public void testHomePage() {
        LoggerManager.info("INIZIO TEST - testHomepage");
        Navigation navigation = new Navigation(getDriver());

        AllureManager.logStep("Apriamo la HomePage");
        navigation.openHomePage(getBaseUrl());

        AllureManager.logStep("Verifica del titolo della HomePage");
        navigation.verifyHomePageTitle();

        AllureManager.logStep("Verifica del pulsante 'Accetta Cookies' visibile");
        navigation.verifyAcceptCookiesButtonIsVisible();

        LoggerManager.info("FINE TEST - testHomepage");
    }

    @Test(retryAnalyzer = core.retry.RetryAnalyzer.class)
    @Description("Questo test accetta i cookies e chiude il banner superiore della HomePage di Zurich")
    @Severity(SeverityLevel.NORMAL)
    @Story("Accettazione cookies e chiusura banner")
    public void testExample() {
        LoggerManager.info("INIZIO TEST - testExample");
        Navigation navigation = new Navigation(getDriver());

        AllureManager.logStep("Apriamo la HomePage");
        navigation.openHomePage(getBaseUrl());

        AllureManager.logStep("Verifica del titolo della HomePage");
        navigation.verifyHomePageTitle();

        AllureManager.logStep("Verifica e click sul pulsante 'Accetta Cookies'");
        navigation.verifyAndClickAcceptCookiesButton();

        AllureManager.logStep("Verifica e click sul pulsante 'Non Adesso'");
        navigation.verifyAndClickNotNowButton();

        LoggerManager.info("FINE TEST - testExample");
    }
}
