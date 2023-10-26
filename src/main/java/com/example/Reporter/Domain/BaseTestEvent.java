package com.example.Reporter.Domain;

import org.testng.ITestResult;

import com.example.Reporter.DTO.TestSuiteResultDTO;

import java.lang.reflect.Method;

public class BaseTestEvent {
    private Method method;
    private ITestResult testNgResult;
    private TestSuiteResultDTO tResult;
    private Object[] testData;
    private String description;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ITestResult getITestResult() {
        return testNgResult;
    }

    public void setITestResult(ITestResult testNgResult) {
        this.testNgResult = testNgResult;
    }

    public TestSuiteResultDTO getTestResultDTO() {
        return tResult;
    }

    public void setTestResultDTO(TestSuiteResultDTO tResult) {
        this.tResult = tResult;
    }

    public Object[] getTestData() {
        return testData;
    }

    public void setTestData(Object[] testData) {
        this.testData = testData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
