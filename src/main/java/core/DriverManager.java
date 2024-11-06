package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Metodo per ottenere il WebDriver in base al browser configurato
    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            boolean isRemoteExecution = ConfigManager.getProperty("REMOTE_EXECUTION").equalsIgnoreCase("Y");

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--headless");
                    if (isRemoteExecution) {
                        try {
                            driver.set(new RemoteWebDriver(new URL(ConfigManager.getProperty("SELENIUM_GRID_URL")), chromeOptions));
                        } catch (MalformedURLException e) {
                            throw new RuntimeException("URL del Selenium Grid non valido", e);
                        }
                    } else {
                        driver.set(new ChromeDriver(chromeOptions));
                    }
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-private");
                    firefoxOptions.addArguments("-headless");
                    if (isRemoteExecution) {
                        try {
                            driver.set(new RemoteWebDriver(new URL(ConfigManager.getProperty("SELENIUM_GRID_URL")), firefoxOptions));
                        } catch (MalformedURLException e) {
                            throw new RuntimeException("URL del Selenium Grid non valido", e);
                        }
                    } else {
                        driver.set(new FirefoxDriver(firefoxOptions));
                    }
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("-inprivate");
                    edgeOptions.addArguments("--headless");
                    if (isRemoteExecution) {
                        try {
                            driver.set(new RemoteWebDriver(new URL(ConfigManager.getProperty("SELENIUM_GRID_URL")), edgeOptions));
                        } catch (MalformedURLException e) {
                            throw new RuntimeException("URL del Selenium Grid non valido", e);
                        }
                    } else {
                        driver.set(new EdgeDriver(edgeOptions));
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Browser non supportato: " + browser);
            }

            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    // Metodo per ottenere l'elenco dei browser dal file di configurazione
    public static List<String> getBrowserList() {
        String browsersConfig = ConfigManager.getProperty("browser");
        String[] browsers = browsersConfig.split(",");
        List<String> browserList = new ArrayList<>();
        for (String browser : browsers) {
            browserList.add(browser.trim());
        }
        return browserList;
    }

    // Metodo per ottenere il WebDriver in base al browser configurato per l'esecuzione parallela
    public static WebDriver getDriverForParallelExecution(String browser) {
        return getDriver(browser);
    }

    // Metodo per chiudere e terminare il WebDriver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();  // Assicura che il driver venga ricreato alla prossima chiamata
        }
    }
}
