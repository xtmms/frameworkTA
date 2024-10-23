package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    // Cattura uno screenshot e lo salva nel percorso specificato
    public static void captureScreenshot(WebDriver driver, String filePath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot salvato in: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Errore durante il salvataggio dello screenshot: " + e.getMessage());
        }
    }
}
