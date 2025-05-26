package org.supplychain.item;

import org.junit.jupiter.api.*;
import org.supplychain.items.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * *******************************************************
 * Package: org.supplychain.item
 * File: ProductTest.java
 * Author: Ochwada
 * Date: Tuesday, 29.Apr.2025, 3:20 PM
 * Description:  Unit tests for the {@code Product} class and its concrete subclasses (e.g., {@code Document},
 *               {@code Electronic}, {@code Perishable}). Since {@code Product} is abstract, it is tested indirectly
 *               via its subclasses.
 * Objective: To verify the behavior of methods defined in the {@code Product} base class such as
 *             {@code getId()}, {@code getName()}, {@code toString()}, and to ensure that subclass-specific
 *             implementations like {@code getType()} work as expected.
 * *******************************************************
 */

public class ProductTest {
    /**
     * Covered scenarios:
     *   - Correct ID formatting with "PRO-" prefix
     *   - Accurate retrieval of product name
     *   - Proper subclass type returned from {@code getType()}
     *   - Valid string representation of the product
     *
     */
    private List<Product> items;

    @BeforeAll
    static void beforeAllTest(){
        System.out.println("\uD83E\uDDFF Starting Vehicle Test... ");
    }
    @BeforeEach
    void setUp(){
        items = new ArrayList<>();
        items.add(new Document("PRO-45", "What is Ardhi?"));
        items.add(new Perishable("PRO-44", "Chocolate", 6));
    }
    // -----------------------------------------------------
    // -----------------------------------------------------

    @Test
    @DisplayName("Get ID and Name")
    void testGetIdAndName() {
        Product doc = new Document("123", "User Manual");

        assertEquals("User Manual", doc.getName());
        assertEquals("PRO-123", doc.getId());
    }

    @Test
    @DisplayName("Get Type Test")
    void testGetType() {
        Product doc = new Document("456", "Project Doc");
        assertEquals("Document", doc.getType());
    }

    @Test
    @DisplayName("Print to String")
    void testToString() {
        Product doc = new Document("789", "Guide");
        String expected = "Product{id='789', name='Guide'}";
        assertEquals(expected, doc.toString());
    }

    // -----------------------------------------------------
    // -----------------------------------------------------
    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests(){
        System.out.println("✅ Product Test Completed Successfully!");
    }


}
