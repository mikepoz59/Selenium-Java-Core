package com.example.Reporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logging {
    public static void log(String message) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(String.format("%s - %s", timeStamp, message));
    }
    
}
