package com.example.TestTypes;

import org.testng.annotations.Listeners;

import com.example.Reporter.Logging;

@Listeners(com.example.Listener.Listener.class)
public class BaseTest {
    public void sleepFor(int seconds) {
        try {
            Logging.log(String.format("Sleeping for [%s] second(s)...", seconds));
            Thread.sleep(1000 * seconds);
        }  catch (Exception ex) {}
    }
}

