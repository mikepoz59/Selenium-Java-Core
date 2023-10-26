package com.example.Reporter.Domain;

import org.apache.commons.lang3.StringUtils;
import org.testng.ITestResult;

import com.example.Reporter.DTO.TestSuiteResultDTO;
import com.example.Reporter.Enum.ExecutionType.*;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class TestEndEvent extends BaseTestEvent {
    private TestSuiteResult status;

    TestEndEvent() {
        // for unit testing of setters and getters
    }

    public TestEndEvent(Method method, ITestResult result, TestSuiteResult status) {
        setMethod(method);
        setITestResult(result);
        this.status = status;
        createTestResult();
    }

    public TestEndEvent(Method method, ITestResult result, TestSuiteResult status, String reason, String comments) {
        setMethod(method);
        setITestResult(result);
        this.status = status;
        createTestResult();
        getTestResult().setFailureReason(reason);
        getTestResult().setComments(comments);
    }

    public TestEndEvent(Method method, ITestResult result, TestSuiteResult status, Object[] testData) {
        setMethod(method);
        setITestResult(result);
        this.status = status;
        setTestData(testData);

        createTestResult();
    }

    private void createTestResult() {
        TestSuiteResultDTO result = new TestSuiteResultDTO();
        if (null != getMethod()) {
            result.setName(getMethod().getName());
        }

        result.setName(getTestNgResult().getMethod().getXmlTest().getName());
        result.setResult(status);
        result.setStartTime(Date.from(Instant.ofEpochMilli(getTestNgResult().getStartMillis())));
        result.setEndTime(Date.from(Instant.ofEpochMilli(getTestNgResult().getEndMillis())));
        result.setDuration(Duration.ofMillis(getTestNgResult().getEndMillis() - getTestNgResult().getStartMillis()));
        result.setDescription(getTestNgResult().getMethod().getDescription());

        if (getTestNgResult().getMethod().getXmlTest().getAllParameters().get("platform-type") != null) {
            result.setWebDriver(getTestNgResult().getMethod().getXmlTest().getAllParameters().get("platform-type"));
        }

        setTestResultDTO(result);
    }

    public TestSuiteResultDTO getTestResult() {
        return getTestResultDTO();
    }
    public ITestResult getTestNgResult() {
        return getITestResult();
    }

    public TestSuiteResult getStatus() {
        return status;
    }

    public String getFailureReason() {
        return getTestResultDTO().getFailureReason();
    }

    public void setFailureReason(String failureReason) {
        getTestResultDTO().setFailureReason(failureReason);
    }

    public String getComments() {
        if (StringUtils.isNotBlank(getTestResultDTO().getComments())) {
            return getTestResultDTO().getComments();
        } else {
            return StringUtils.EMPTY;
        }
    }

    public void setComments(String comments) {
        getTestResultDTO().setComments(comments);
    }
}
