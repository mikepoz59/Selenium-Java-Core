package com.example.Reporter.Domain;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.Date;

import org.testng.ITestResult;

import com.example.Reporter.DTO.TestSuiteResultDTO;

public class TestStartEvent extends BaseTestEvent {

    TestStartEvent() {
        // for unit testing of setters and getters
    }

    public TestStartEvent(Method method, ITestResult result, Object[] testData) {
        setMethod(method);
        setITestResult(result);
        setTestData(testData);

        createTestResult();
    }

    private void createTestResult() {
        TestSuiteResultDTO tResult = new TestSuiteResultDTO();
        tResult.setName(getMethod().getName());
        tResult.setStartTime(Date.from(Instant.now()));
        setTestResultDTO(tResult);
    }

    public TestSuiteResultDTO getTestResult() {
        return getTestResultDTO();
    }

    public ITestResult getTestNgResult() {
        return getITestResult();
    }

    @Override
    public String toString() {
        return "TestStartEvent [method=" + getMethod() + "]";
    }
}
