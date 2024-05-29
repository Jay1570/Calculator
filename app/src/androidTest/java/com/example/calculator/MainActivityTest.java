package com.example.calculator;

import junit.framework.TestCase;

public class MainActivityTest extends TestCase {

    public void testOnCreate() {
        MainActivity activity = new MainActivity();
        activity.onCreate(null);
    }

    public void testAid() {
        MainActivity activity = new MainActivity();
        activity.onCreate(null);
    }

    public void testOnClick() {
        MainActivity activity = new MainActivity();
        activity.onCreate(null);
    }

    public void testGetresult() {
        MainActivity activity = new MainActivity();
        activity.getResult("12+23/35");
    }
}