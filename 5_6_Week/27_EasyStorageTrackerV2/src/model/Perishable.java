package model;


/**
 * *******************************************************
 * Package: model
 * File: Perishable.java
 * Author: Ochwada
 * Date: Thursday, 24.Apr.2025, 12:32 PM
 * Description: Model something like milk using a simple number as expiration logic.
 * Objective:
 *          We’re using int instead of LocalDate, so you can just say today is day 12, and if the item expires on day 10 -> it's expired.
 * *******************************************************
 */

public abstract class Perishable {
 private int expirationDay; // Example: day 10

 public Perishable(int expirationDay) {
  this.expirationDay = expirationDay;
 }

 public boolean isExpired(int currentDay) {
  return currentDay > expirationDay;
 }

 public int getExpirationDay() {
  return expirationDay;
 }
}
