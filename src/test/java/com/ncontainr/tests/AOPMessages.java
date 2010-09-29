package com.ncontainr.tests;

import java.util.ArrayList;
import java.util.List;

public class AOPMessages {
    
    private static AOPMessages instance = null;

    private List<String> before;

    private List<String> after;

    private AOPMessages() {
        before = new ArrayList<String>();
        after = new ArrayList<String>();
    }

    public static AOPMessages getInstance() {
        if (instance == null)
            instance = new AOPMessages();
        return instance;
    }

    public void addBefore(String message) {
        this.before.add(message);
    }

    public void addAfter(String message) {
        this.after.add(message);
    }

    public List<String> getAfter() {
        return after;
    }

    public List<String> getBefore() {
        return before;
    }
}
