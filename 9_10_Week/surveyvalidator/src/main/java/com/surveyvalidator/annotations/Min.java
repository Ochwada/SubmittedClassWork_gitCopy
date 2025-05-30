package com.surveyvalidator.annotations;


import java.lang.annotation.*;

/**
 * *******************************************************
 * Package: com.surveyvalidator
 * File: Min.java
 * Author: Ochwada
 * Date: Tuesday, 27.May.2025, 2:55 PM
 * Description:
 * Objective:
 * *******************************************************
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

/**
 * Annotation to specify a minimum numeric value constraint for a field.
 *
 * - Applied to numeric fields (e.g., int, Integer).
 * - Used during validation to ensure the field's value is >= the specified minimum.
 *
 * Example:
 *   @Min(18)
 *   private int age;
 */
public @interface Min {
    int value();
}
