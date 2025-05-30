package com.surveyvalidator.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * *******************************************************
 * Package: com.surveyvalidator
 * File: Email.java
 * Author: Ochwada
 * Date: Tuesday, 27.May.2025, 2:55 PM
 * Description:
 * Objective:
 * *******************************************************
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

/**
 * Annotation to mark a field as requiring a valid email format.
 * - Applied to String fields.
 * - Used during validation to ensure the value matches a basic email pattern.
 * <p>
 * Example:
 *   @Email
 *   private String email;
 */
public @interface Email {
}
