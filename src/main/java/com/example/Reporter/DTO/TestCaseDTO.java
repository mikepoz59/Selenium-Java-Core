package com.example.Reporter.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.Reporter.Enum.ExecutionType.*;

public class TestCaseDTO {

    private TestCaseResult result;
    private List<TestStepDTO> testSteps;
    private TestCaseType type;

    public List<TestStepDTO> getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(List<TestStepDTO> testSteps) {
        this.testSteps = testSteps;
    }

    public void addTestStep(TestStepDTO step) {
        if (this.testSteps == null) {
            this.testSteps = new ArrayList<>();
        }

        this.testSteps.add(step);
    }

    public TestCaseResult getResult() {
        return result;
    }

    public void setResult(TestCaseResult result) {
        this.result = result;
    }

    
    public TestCaseType getType() {
        return type;
    }

    public void setType(TestCaseType type) {
        this.type = type;
    }
}
