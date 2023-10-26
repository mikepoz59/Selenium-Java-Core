package com.example.Config;

import java.util.Properties;

public interface ITestConfig {
    String get(String key);

    void set(String key, String value);

    Properties getAll();

    void release();
}
