package com.ncontainr.tests;

import com.ncontainr.api.annotations.Intercept;
import com.ncontainr.api.annotations.PostConstruct;
import com.ncontainr.api.annotations.PreDestroy;

public class LoggerImpl implements Logger {

    @PostConstruct
    public void start() {
        System.out.println("start");
    }

    @PreDestroy
    public void stop() {
        System.out.println("stop");
    }

    @Override
    @Intercept(Interceptor.class)
    public void log(String message) {
        System.out.println("[ LOGGER IMPL ] " + message);
    }
}
