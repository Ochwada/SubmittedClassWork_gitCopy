package com.surveyvalidator.annotations;


import java.lang.annotation.*;

/**
 * *******************************************************
 * Package: com.surveyvalidator
 * File: NotNull.java
 * Author: Ochwada
 * Date: Tuesday, 27.May.2025, 2:27 PM
 * Description: Indicates that the annotated field must not be null.
 * - Applied to fields to enforce non-null constraints during validation.
 * Objective: Designed to be used at runtime with reflection-based validators.
 * *******************************************************
 */


/**
 * @Retention defines how long the annotation should be retained.
 * RetentionPolicy.RUNTIME means:
 * → The annotation {@code NotNull} will be available at runtime via reflection.
 * → This is critical because validators need to inspect class fields dynamically and check if @NotNull is present.
 * @Retention(RetentionPolicy.RUNTIME) — Makes @NotNull available at runtime for validators. (Speaks on time)
 */
@Retention(RetentionPolicy.RUNTIME)


/**
 * @Target defines where this annotation can be applied in the code. (add before what?)
 * ElementType.FIELD means:
 *  → This annotation can only be applied to fields (i.e., instance variables or class variables).
 *  → You **cannot** apply it to methods, constructors, parameters, etc.

 * @Target(ElementType.FIELD) — Restricts/limits the use of @NotNull(annotation) to fields only (e.g. class variables)
 */
@Target(ElementType.FIELD)


/**
 * Defines a custom annotation called @NotNull.
 * public — Makes it accessible from any package (even outside this package).
 * @interface — Declares this is a custom annotation, not a class or interface (the Java keyword for defining an annotation)
 * No elements — It's a marker annotation (no values or parameters needed).
 *
 * @interface NotNull — Declares the annotation itself / marker annotation
 */
public @interface NotNull {

}
