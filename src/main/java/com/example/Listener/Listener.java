package com.example.Listener;

import org.testng.ITestContext;  
import org.testng.ITestListener;  
import org.testng.ITestResult;  

public class Listener implements ITestListener {
    @Override
    // Start of test suite
    public void onTestStart(ITestResult result) {  
        System.out.println("Start of test case and its details are : " + result.getName());  
    }  
      
    @Override
    // end of test case that passed
    public void onTestSuccess(ITestResult result) {  
        System.out.println("Success of test case and its details are : " + result.getName());  
    }  
      
    @Override  
    // end of test case that faioled
    public void onTestFailure(ITestResult result) {  
        System.out.println("Failure of test cases and its details are : "+result.getName());  
    }  
      
    @Override
    // End of test case that was skipped
    public void onTestSkipped(ITestResult result) {  
        System.out.println("Skip of test cases and its details are : "+result.getName());  
    }  
      
    @Override
    // End of test case that failed
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
        System.out.println("Failure of test cases and its details are : "+result.getName());  
    }  
      
    @Override   
    // Start of test suite  
    public void onStart(ITestContext context) {  
        System.out.println("Start of test suite and its details are : " + context.getName());  
    }  
      
    @Override  
    // End of test suite
    public void onFinish(ITestContext context) {  
        System.out.println("End of test suite and its details are : " + context.getName());  
    }  
}
