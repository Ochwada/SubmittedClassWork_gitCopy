package com.myapp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       // Statistics stat = new Statistics(); --> used if the method isn't static

        System.out.println("-- Calculator --");

        double a = 30;
        double b = 20.5;
        double add = Statistics.addition(a, b);
        double minus = Statistics.substraction(a, b);
        double times = Statistics.multiplication(a, b);
        double divide = Statistics.division(a, b);



        System.out.println("addition"+ a + " + " + b + "= " + add );
        System.out.println("substraction"+  a + " - " + b + "= " + minus );
        System.out.println("multiplication"+ a + " * " + b + "= " + times );
        System.out.println("division"+ a + " / " + b + "= " + divide );

        double divideByZero = Statistics.division(1, 0);
        System.out.println("divideByZero :" + divideByZero );
    }
}
