package com.surveyvalidator.annotations;


import java.lang.annotation.*;

/**
 * *******************************************************
 * Package: com.surveyvalidator
 * File: Length.java
 * Author: Ochwada
 * Date: Tuesday, 27.May.2025, 2:28 PM
 * Description:
 * Objective:
 * *******************************************************
 */


/**
 * Annotation to specify minimum and maximum length constraints for a field.
 * <p>
 * - Applied to String fields.
 * - Used during validation to ensure the string's length is between min and max.
 * <p>
 * Example: @Length(min = 3, max = 20)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface Length {
    // Minimum allowed length (default = 0)
    int min() default 0;

    // Maximum allowed length (default = unlimited)
    int max() default Integer.MAX_VALUE;
}
