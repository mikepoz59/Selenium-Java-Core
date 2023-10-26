package com.example.Reporter.DTO;

import com.example.Reporter.Enum.ExecutionType.*;

public class TestStepDTO {
    private TestStepResult result;
    private TestStepType type;

    public TestStepResult getResult() {
        return result;
    }

    public void setResult(TestStepResult result) {
        this.result = result;
    }

    
    public TestStepType getType() {
        return type;
    }

    public void setType(TestStepType type) {
        this.type = type;
    }
}
