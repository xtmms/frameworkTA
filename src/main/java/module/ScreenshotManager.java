package module;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotManager {

    private WebDriver driver;

    // Costruttore per inizializzare il WebDriver
    public ScreenshotManager(WebDriver driver) {
        this.driver = driver;
    }

    // Metodo per catturare screenshot in caso di test passato o fallito
    public void takeScreenshot(ITestResult result, ITestContext context, boolean isTestPassed) {
        // Ottieni il nome della suite e del test dinamicamente
        String suiteName = context.getSuite().getName();
        String testName = result.getMethod().getMethodName();
        String status = isTestPassed ? "passed" : "failed";

        // Formattazione della data per il nome della cartella e del file
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        // Definizione del percorso della cartella screenshot
        String screenshotDirectory = "target/screenshots/" + suiteName + "/" + testName + "/" + status;
        new File(screenshotDirectory).mkdirs(); // Crea la cartella se non esiste

        // Nome del file screenshot
        String screenshotPath = screenshotDirectory + "/screenshot_" + timestamp + ".png";

        // Cattura lo screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            System.out.println("Screenshot salvato in: " + screenshotPath);
        } catch (IOException e) {
            throw new RuntimeException("Errore durante il salvataggio dello screenshot: " + e.getMessage());
        }
    }
}
