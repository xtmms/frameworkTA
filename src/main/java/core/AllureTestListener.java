package core;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class AllureTestListener implements ITestListener {

    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        AllureManager.addScreenshot("Test Passed - " + result.getName(), driver);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AllureManager.addScreenshot("Test Failed - " + result.getName(), driver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        AllureManager.addScreenshot("Test Skipped - " + result.getName(), driver);
    }

    @Override
    public void onStart(ITestContext context) {
        // Puoi aggiungere log opzionali se necessario
    }

    @Override
    public void onFinish(ITestContext context) {
        // Puoi aggiungere log opzionali se necessario
    }
}

