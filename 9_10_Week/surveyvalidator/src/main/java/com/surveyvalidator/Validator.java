package com.surveyvalidator;


import com.surveyvalidator.annotations.*;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * *******************************************************
 * Package: com.surveyvalidator
 * File: Validator.java
 * Author: Ochwada
 * Date: Tuesday, 27.May.2025, 3:05 PM
 * Description: Validator class uses reflection to validate any object with custom annotations.
 * Objective: Use Reflection to enforce annotation rules
 * *******************************************************
 */


/**
 * Purpose: A utility class that uses Java Reflection to inspect
 * and validate an object's fields based on custom annotations.
 * <p>
 * Main Idea:
 * - Reads an object's fields at runtime.
 * - Enables you to later apply validation logic (e.g., @NotNull, @Min, @Email, @Length).
 */

public class Validator {

    /**
     * Validates fields of the provided object using reflection (Fields: name, age, email and feedback)
     *
     * @param obj The object to validate (e.g., SurveyResponse instance).
     * @throws IllegalAccessException if field access is not allowed.
     *                                <p>
     *                                Workflow:
     *                                1. Get the Class type of the object (blueprint).
     *                                2. Loop through all declared fields (variables) in the class.
     *                                3. Make each field accessible (even if private).
     *                                4. Get the actual value of each field from the given object.
     *                                <p>
     *                                This sets up the structure. Now:
     *                                - Check if each field has an annotation (e.g., @NotNull)
     *                                - Validate its value
     */
    public static void validate(Object obj) throws IllegalAccessException {

        // Step 1: Get the class definition of the object (its blueprint)
        Class<?> clazz = obj.getClass();

        // Step 2: Loop over all declared fields (private, public, protected - Fields: name, age, email and feedback)
        for (Field field : clazz.getDeclaredFields()) {
            // Enable access to private fields
            field.setAccessible(true);

            // Read the actual value of the field from the given object
            Object value = field.get(obj);

            // Step 3: Check annotations like @NotNull, @Min, @Length & @Email
            // ------------------------------------------
            // a) Validation for @NotNull
            // ------------------------------------------
            /**
             * Checks if the field is annotated with @NotNull and if its value is null.
             * Purpose:
             * - Ensures required fields are not left empty (null).
             *
             * Logic:
             * - `field.isAnnotationPresent(NotNull.class)` checks whether @NotNull is applied.
             * - `value == null` confirms the field was not initialized.
             * - If both are true, validation fails and an exception is thrown.
             * "If the field has a @NotNull annotation AND the value of that field is null, then it's a validation error."
             */
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                throw new IllegalArgumentException(
                        "Field '" + field.getName() + "' must not be null"
                );
            }
            // ------------------------------------------
            // b) Validation for @Min
            // ------------------------------------------
            /**
             * Validates that a numeric field meets the minimum value defined by the @Min annotation.
             * Logic:
             * - `field.isAnnotationPresent(Min.class)` checks if @Min is present on the field.
             * - `field.getAnnotation(Min.class).value()` retrieves the minimum value defined in the annotation.
             * - `(Integer) value < min` compares the actual value to the required minimum.
             * - If the value is less than the defined minimum, an IllegalAccessException is thrown.
             *
             * Note:
             * - Assumes the value is of type Integer.
             * - Should be preceded by a type check (e.g., `value instanceof Integer`) for safety in a full implementation.
             */
            if (field.isAnnotationPresent(Min.class) && value instanceof Integer) {

                int min = field.getAnnotation(Min.class).value();

                if ((Integer) value < min) {
                    throw new IllegalArgumentException(
                            "Field '" + field.getName() + "' must be at least " + min
                    );
                }
            }
            // ------------------------------------------
            // c) Validation for @Length
            // ------------------------------------------
            /**
             * Validates that a String field's length is within the min and max bounds
             * defined by the @Length annotation.
             *
             * Logic:
             * - `field.isAnnotationPresent(Length.class)` checks if the field is annotated with @Length.
             * - `value instanceof String` ensures the field's value is a String before proceeding.
             * - `len.min()` and `len.max()` get the allowed character limits from the annotation.
             * - `str.length()` computes the actual length of the String.
             * - If the string's length is outside the valid range, an IllegalArgumentException is thrown
             */
            if (field.isAnnotationPresent(Length.class) && value instanceof String) {

                Length len = field.getAnnotation(Length.class);
                String str = (String) value;

                if (str.length() < len.min() || str.length() > len.max()) {
                    throw new IllegalArgumentException(
                            "Field '" + field.getName() + "' must be between " +
                                    len.min() + " and " + len.max() + " characters."
                    );
                }
            }
            // ------------------------------------------
            // d) Validation for @Email
            // ------------------------------------------
            /**
             * Validates that a String field annotated with @Email has a valid email format.
             *
             * Logic:
             * - `field.isAnnotationPresent(Email.class)` checks if @Email is applied to the field.
             * - `value instanceof String` ensures the field's value is a String.
             * - A regular expression (regex) is used to define the valid email format.
             * - `Pattern.matches(regex, email)` checks whether the field's value matches the email pattern.
             * - If the format is invalid, an IllegalArgumentException is thrown.
             *
             * Regex used:
             *   "^[A-Za-z0-9+_.-]+@(.+)$"
             *   → Accepts standard email formats like: john.doe@example.com
             *
             * Example:
             *   @Email
             *   private String email;
             *
             *   If email = "invalid-email.com" → error:
             *   "Field 'email' must be a valid email."
             */
            if (field.isAnnotationPresent(Email.class) && value instanceof String) {

                String email = (String) value;
                String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

                if (!Pattern.matches(regex, email)) {
                    throw new IllegalArgumentException(
                            "Field '" + field.getName() + "' must be a valid email."
                    );
                }
            }

        }

    }
}
