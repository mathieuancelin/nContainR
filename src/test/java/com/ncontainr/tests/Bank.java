package com.ncontainr.tests;

import javax.inject.Inject;

public class Bank {

    private Logger logger;

    public Bank() {}

    @Inject
    public Bank(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }

    public void log() {
        logger.log("Welcome to the jungle :)");
    }
}
