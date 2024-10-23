package core;

import module.ScreenshotManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WaitUtils;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected ScreenshotManager screenshotManager;  // ScreenshotManager non è statico
    private static final String BASE_URL = ConfigManager.getProperty("base.url");

    @BeforeMethod
    public void setUp(ITestContext context) {
        // Ottieni l'elenco dei browser dal file di configurazione
        List<String> browsers = DriverManager.getBrowserList();
        String browser = context.getCurrentXmlTest().getParameter("browser");
        if (browser == null || browser.isEmpty()) {
            browser = browsers.get(0); // Utilizza il primo browser configurato se non è specificato
        }

        // Inizializza il WebDriver tramite DriverManager
        driver = DriverManager.getDriver(browser);

        // Inizializza WaitUtils
        waitUtils = new WaitUtils(driver);

        // Inizializza ScreenshotManager
        screenshotManager = new ScreenshotManager(driver);

        // Altre configurazioni comuni come massimizzare la finestra
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result, ITestContext context) {
        // Verifica il risultato del test per determinare se è passato o fallito
        boolean isTestPassed = result.getStatus() == ITestResult.SUCCESS;

        // Cattura lo screenshot al termine del test, sia se è passato che fallito
        screenshotManager.takeScreenshot(result, context, isTestPassed);

        // Chiudi il driver
        DriverManager.quitDriver();
    }

    // Metodo helper per ottenere il driver nei test
    public WebDriver getDriver() {
        return driver;
    }

    // Metodo helper per accedere all'URL di base
    public String getBaseUrl() {
        return BASE_URL;
    }
}

