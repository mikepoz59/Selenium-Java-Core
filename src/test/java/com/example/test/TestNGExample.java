package com.example.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.Reporter.Logging;
import com.example.TestTypes.WebTest;

public class TestNGExample extends WebTest {

    @Test  
    public void openBrowserAndNavigateBing() {
        WebDriver driver = null;
        {  
            try {
                Logging.log("Starting test");
                String targetUrl = "https://www.bing.com/";
                driver = getWebDriver(Browser.EDGE);
                driver.get(targetUrl);
                waitForDocumentLoad(driver);
                WebElement searchBox = driver.findElement(By.id("sb_form_q"));
                Assert.assertNotNull(searchBox, "Search Box found");
                searchBox.click();
                searchBox.sendKeys("Selenium Test", Keys.RETURN);
                waitForDocumentLoad(driver);
                Assert.assertTrue(driver.getPageSource().contains("Overview of Test Automation | Selenium"));

            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
        }  
    }

    @Test  
    public void openBrowserAndNavigateToGoogle() {
        WebDriver driver = null;
        {  
            try {
                Logging.log("Starting test");
                String targetUrl = "https://www.google.com/";
                driver = getWebDriver(Browser.CHROME);
                driver.get(targetUrl);
                waitForDocumentLoad(driver);
                WebElement searchBox = driver.findElement(By.name("q"));
                Assert.assertNotNull(searchBox, "Search Box found");
                searchBox.sendKeys("Selenium Test", Keys.RETURN);
                waitForDocumentLoad(driver);

                Assert.assertTrue(driver.getPageSource().contains("Selenium WebDriver"));

            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
        }  
    }

    @Test  
    public void openBrowserAndNavigateMSN() {
        WebDriver driver = null;
        {  
            try {
                Logging.log("Starting test");
                String targetUrl = "https://www.msn.com/";
                driver = getWebDriver(Browser.EDGE);
                driver.get(targetUrl);
                waitForDocumentLoad(driver, 2);
                Set<String> handles = driver.getWindowHandles();
                
                /* Normally we would do this to find the WebElement:
                
                    ----> WebElement searchBox = driver.findElement(By.id("q"));
                
                   However because the element is in a nested shadow DOM, 
                   we have to find it using javascript. 
                */ 

                // provide access to Javascript
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

                // Find the web element so we can perform an action.
                WebElement searchBox = (WebElement)jsExecutor.executeScript("return document.querySelector('entry-point')." + 
                        "shadowRoot.querySelector('homepage-header')." + 
                        "shadowRoot.querySelector('msn-search-box')." +
                        "shadowRoot.querySelector('#q')");
                Assert.assertNotNull(searchBox, "Search Box found");
                searchBox.click();
                searchBox.sendKeys("Selenium Test", Keys.RETURN);
                waitForDocumentLoad(driver, 2);
                Set<String> handles2 = driver.getWindowHandles();
                if (handles.size() < handles2.size()) {
                    // switch to the new handle
                    for (String handle : handles2) {
                        if (!handles.contains(handle)) {
                            driver.switchTo().window(handle);
                        }
                    }
                }

                Assert.assertTrue(driver.getPageSource().contains("Overview of Test Automation | Selenium"));
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
        }  
    }
}
