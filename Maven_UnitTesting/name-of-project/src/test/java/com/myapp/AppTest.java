package com.myapp;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest{

@org.junit.Test
public void testAdd(){
    //Statistics stat = new Statistics(); // only without static

    double actual =  Statistics.addition(3.0,2.0);
    assertEquals(5.0, actual, 0.0);

}

//
//    extends TestCase
//{
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
}
