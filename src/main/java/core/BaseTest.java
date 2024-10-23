package core;

import module.ScreenshotManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utils.WaitUtils;

public class BaseTest {

    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected ScreenshotManager screenshotManager;
    protected SoftAssert softAssert;
    private static final String BASE_URL = ConfigManager.getProperty("base.url");

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser, ITestContext context) {
        // Inizializza il WebDriver tramite DriverManager
        driver = DriverManager.getDriver(browser);

        // Inizializza WaitUtils e ScreenshotManager
        waitUtils = new WaitUtils(driver);
        screenshotManager = new ScreenshotManager(driver);

        // Inizializza SoftAssert
        softAssert = new SoftAssert();

        // Altre configurazioni comuni come massimizzare la finestra
        driver.manage().window().maximize();

        // Passa il driver al contesto del test
        context.setAttribute("WebDriver", driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result, ITestContext context) {
        // Verifica il risultato del test per determinare se è passato o fallito
        boolean isTestPassed = result.getStatus() == ITestResult.SUCCESS;

        // Cattura lo screenshot al termine del test
        screenshotManager.takeScreenshot(result, context, isTestPassed);

        // Richiama assertAll per raccogliere tutte le asserzioni
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            LoggerManager.error("AssertAll ha fallito: " + e.getMessage());
            throw e;  // Rilancia l'errore per segnalare il fallimento del test
        }

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

    // Metodo helper per ottenere SoftAssert nei test
    public SoftAssert getSoftAssert() {
        return softAssert;
    }
}

