package com.example.Reporter.Enum;
public class ExecutionType {
    public enum TestSuiteResult {
        PASS,
        FAIL,
        SKIP,
        NORUN;    
    }
    
    public enum TestCaseResult {
        PASS,
        FAIL,
        SKIP,
        NORUN;    
    }

    public enum TestCaseType {
        API,
        HYBRID,
        UI;
    }

    public enum TestStepResult {
        PASS,
        FAIL,
        SKIP,
        NORUN;    
    }

    public enum TestStepType {
        SERVICECALL,
        UI;
    }

    public enum TestEventResult {
        PASS,
        FAIL;
    }
}
