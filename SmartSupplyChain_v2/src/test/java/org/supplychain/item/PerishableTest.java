package org.supplychain.item;

import org.junit.jupiter.api.*;
import org.supplychain.exception.*;
import org.supplychain.items.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * *******************************************************
 * Package: org.supplychain.item
 * File: PerishableTest.java
 * Author: Ochwada
 * Date: Tuesday, 29.Apr.2025, 5:13 PM
 * Description: Test the methods in items.Perishable
 * Objective:
 * *******************************************************
 */

public class PerishableTest {

    private Perishable expiredItem;
    private Perishable validItem;


    @BeforeAll
    static void beforeAllTest(){
        System.out.println("\uD83E\uDDFF Starting Perishable Test... ");
    }

    @BeforeEach
    void setUp() {
        expiredItem = new Perishable("X1", "Expired Milk", 1);     // Definitely expired
        validItem   = new Perishable("X2", "Fresh Yogurt", 400);   // Not expired
    }
    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------
    @Test
    @DisplayName("Expired Goods' Test")
    void testIsExpired_ShouldReturnTrue_WhenTodayIsAfterExpirationDay() {
        int expiredDay = 20; // way before today  --- Tested on day 119
        Perishable milk = new Perishable("P1", "Milk", expiredDay);

        assertTrue(milk.isExpired(), "Expected milk to be expired");
    }

    @Test
    @DisplayName("Not-Expired Goods' Test")
    void testIsExpired_ShouldReturnFalse_WhenTodayIsBeforeExpirationDay() {
        int futureDay = 400; // well after today --- Tested on day 119
        Perishable juice = new Perishable("P2", "Juice", futureDay);

        assertFalse(juice.isExpired(), "Expected juice not to be expired");
    }

    @Test
    @DisplayName("Test for Exception when Expired - Show Expectation")
    void testValidateExpiration_ShouldThrowException_WhenExpired() {
        int expiredDay = 5;
        Perishable cheese = new Perishable("P3", "Cheese", expiredDay);

        assertThrows(ExpiredProductException.class, cheese::validateExpiration);
    }

    @Test
    @DisplayName("Test for Exception when Expired - Do not Show Expectation")
    void testValidateExpiration_ShouldNotThrow_WhenNotExpired() {
        int futureDay = 400;
        Perishable yogurt = new Perishable("P4", "Yogurt", futureDay);

        assertDoesNotThrow(yogurt::validateExpiration);
    }

    @Test
    @DisplayName("Return formatted Text")
    void testToString_ShouldReturnFormattedText() {
        Perishable bread = new Perishable("P5", "Bread", 123);

        assertEquals("Bread (Expires on day 123)", bread.toString());
    }

        // -----------------------------------------------------
    // -----------------------------------------------------
    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests(){
        System.out.println("✅ Perishable Test Completed Successfully!");
    }
}
