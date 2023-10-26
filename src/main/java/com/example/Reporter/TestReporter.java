package com.example.Reporter;

import com.example.Config.ITestConfig;
import com.example.Reporter.Domain.*;

public interface TestReporter {
    void testStart(TestStartEvent testStartevent);

    void testEnd(TestEndEvent testEndEvent, ITestConfig testConfig);
}
