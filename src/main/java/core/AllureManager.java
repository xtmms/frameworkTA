package core;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureManager {

    @Step("{stepDescription}")
    public static void logStep(String stepDescription) {
        // Log di un passo nel report di Allure
    }

    public static void addAttachment(String attachmentName, String content) {
        Allure.addAttachment(attachmentName, new ByteArrayInputStream(content.getBytes()));
    }

    public static void addScreenshot(String screenshotName, WebDriver driver) {
        if (driver != null) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(screenshotName, new ByteArrayInputStream(screenshotBytes));
        }
    }
}
