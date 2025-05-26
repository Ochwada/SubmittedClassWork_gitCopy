package com.myapp;


/**
 * *******************************************************
 * Package: com.myapp
 * File: Statistics.java
 * Author: Ochwada
 * Date: Friday, 25.Apr.2025, 11:32 AM
 * Description: A number of methods for Statistic calculations
 * Objective: Practice with Maven
 * *******************************************************
 */

public class Statistics {

 public static double addition(double a, double b) {
  return a + b;
 }

 public static double substraction(double a, double b) {
  return a - b;
 }

 public static double multiplication(double a, double b) {
  return a * b;
 }

 public static double division(double a, double b) {
  if (b == 0) {
   throw new IllegalArgumentException("Cannot divide by 0");
  }
  return a / b;
 }
}
