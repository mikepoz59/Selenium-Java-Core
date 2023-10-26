package com.example.TestTypes;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTest extends BaseTest {
    public enum Browser {
        CHROME,
        EDGE,
        FIREFOX;
    }

    public WebDriver getWebDriver(Browser browser) {
        WebDriver driver = null;
        switch (browser) {
            case EDGE: {
                System.setProperty("webdriver.msedgedriver.driver","C:\\Tools\\WebDrivers\\Edge\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            }

            case FIREFOX: {
                System.setProperty("webdriver.gecko.driver","C:\\Tools\\WebDrivers\\FireFox\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }

            case CHROME:
            default: {
                driver = new ChromeDriver();
                break;
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().fullscreen();

        return driver;
    }

    public void waitForDocumentLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        boolean loaded = false;
        while (!loaded) {
            loaded = wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState")));
            sleepFor(0);
        }
    }

    public void waitForDocumentLoad(WebDriver driver, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        boolean loaded = false;
        while (!loaded) {
            loaded = wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState")));
            sleepFor(seconds);
        }
    }
}   