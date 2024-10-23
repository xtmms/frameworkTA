package core.retry;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Imposta direttamente il RetryAnalyzer alla classe del metodo fallito
        result.getMethod().setRetryAnalyzerClass(RetryAnalyzer.class);
    }
}

