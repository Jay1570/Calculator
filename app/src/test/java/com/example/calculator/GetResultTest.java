package com.example.calculator;

import org.junit.Assert;
import org.junit.Test;

public class GetResultTest {
    @Test
    public void getResult() {
        int a = 10;
        int b = 10;
        String expected = String.valueOf(Double.valueOf(a + b));
        String ans = MainActivity.getResult(a + "+" + b);
        Assert.assertEquals(expected, ans);
    }
}
