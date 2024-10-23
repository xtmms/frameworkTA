package core.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 1;  // Numero massimo di retry

    @Override
    public boolean retry(ITestResult result) {
        // Riprova solo se il test è stato SKIPPED o FAILED
        if (retryCount < maxRetryCount && (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP)) {
            retryCount++;
            System.out.println("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + retryCount + " time(s).");
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                return "SUCCESS";
            case ITestResult.FAILURE:
                return "FAILURE";
            case ITestResult.SKIP:
                return "SKIP";
            default:
                return "UNKNOWN";
        }
    }
}

