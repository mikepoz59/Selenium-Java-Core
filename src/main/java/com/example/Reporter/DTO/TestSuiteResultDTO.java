package com.example.Reporter.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Reporter.Enum.ExecutionType.*;

public class TestSuiteResultDTO extends BaseDTO {
    private TestSuiteResult result;
    private List<TestCaseDTO> testCases;
    private String webDriver;

    public List<TestCaseDTO> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCaseDTO> testCases) {
        this.testCases = testCases;
    }

    public void addTestCase(TestCaseDTO testCase) {
        if (this.testCases == null) {
            this.testCases = new ArrayList<>();
        }

        this.testCases.add(testCase);
    }

    public List<TestCaseDTO> getPassedTestCases() {
        if (testCases != null && !testCases.isEmpty()) {
            return testCases.stream()
            .filter(testCase -> testCase.getResult().equals(TestCaseResult.PASS))
            .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public List<TestCaseDTO> getFailedTestCases() {
                if (testCases != null && !testCases.isEmpty()) {
            return testCases.stream()
            .filter(testCase -> testCase.getResult().equals(TestCaseResult.FAIL))
            .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

        public List<TestCaseDTO> getOtherTestCases() {
                if (testCases != null && !testCases.isEmpty()) {
            return testCases.stream()
            .filter(testCase -> testCase.getResult().equals(TestCaseResult.SKIP) || testCase.getResult().equals(TestCaseResult.NORUN))
            .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public TestSuiteResult getResult() {
        return result;
    }

    public void setResult(TestSuiteResult result) {
        this.result = result;
    }
    
    public String getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(String webDriver) {
        this.webDriver = webDriver;
    }
}
