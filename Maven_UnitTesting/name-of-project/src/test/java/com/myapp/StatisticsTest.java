package com.myapp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * *******************************************************
 * Package: PACKAGE_NAME
 * File: com.myapp.StatisticTest.java
 * Author: Ochwada
 * Date: Friday, 25.Apr.2025, 11:47 AM
 * Description: Testing
 * Objective:
 * *******************************************************
 */

public class StatisticsTest {

    @Test
    public void testAdd(){
        //Statistics stat = new Statistics(); // only without static
        double actual =  Statistics.addition(3.0,2.0);
        assertEquals(5.0, actual, 0.0);

    }
    @Test
    public void testSubstract(){
        //Statistics stat = new Statistics(); // only without static
        double actual =  Statistics.substraction(3.0,2.0);
        assertEquals(1.0, actual, 0.0);
    }

    @Test
    public void testTimes(){
        //Statistics stat = new Statistics(); // only without static
        double actual =  Statistics.multiplication(3.0,2.0);
        assertEquals(6.0, actual, 0.0);
    }
    @Test
    public void testDivide(){
        //Statistics stat = new Statistics(); // only without static
        double actual =  Statistics.division(2.0,2.0);
        assertEquals(1.0, actual, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero(){
        //Statistics stat = new Statistics(); // only without static
        double actual =  Statistics.division(5,0);
    }

}
