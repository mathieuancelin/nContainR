package com.ncontainr.tests;

public class InterceptorLogger {

    public void log(String message) {
        System.out.println("[ LOGGER INTERCEPTOR ] " + message);
    }
}
