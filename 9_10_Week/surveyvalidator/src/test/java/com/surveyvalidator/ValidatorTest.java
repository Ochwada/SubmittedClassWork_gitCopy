package com.surveyvalidator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * *******************************************************
 * Package: com.surveyvalidator
 * File: ValidatorTest.java
 * Author: Ochwada
 * Date: Tuesday, 27.May.2025, 4:16 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public class ValidatorTest {

    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating Validator Tests...  ");
    }

    @BeforeEach
    void setUp() {
        System.out.println("\uD83D\uDD38 New Setup: Create a new object.");

    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: 📃 " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅  Validator ✨ Tests  Successfully Done ✨");
    }

    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------

    @Test
    @DisplayName("Valid Response Should Pass ")
    void validResponseShouldPass() {
        SurveyResponse res = new SurveyResponse("Alice", 20, "alice@example.com", "Awesome!");
        assertDoesNotThrow(() -> Validator.validate(res));
    }

    @Test
    @DisplayName(" Null Name Should Fail ")
    void nullNameShouldFail() {
        SurveyResponse res = new SurveyResponse(null, 20, "x@example.com", "Nice.");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("name"));
    }

    @Test
    @DisplayName("Bad Email Should Fail")
    void badEmailShouldFail() {
        SurveyResponse res = new SurveyResponse("Bob", 22, "bob.com", "Cool.");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("email"));
    }

    @Test
    @DisplayName("Short Age Should Fail")
    void shortAgeShouldFail() {
        SurveyResponse res = new SurveyResponse("Cara", 17, "cara@example.com", "Ok");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("age"));
    }
}
