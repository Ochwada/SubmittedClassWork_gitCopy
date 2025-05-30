package com.surveyvalidator;


import com.surveyvalidator.annotations.*;

/**
 * *******************************************************
 * Package: com.surveyvalidator
 * File: SurveyResponse.java
 * Author: Ochwada
 * Date: Tuesday, 27.May.2025, 2:26 PM
 * Description: Define a participant’s survey response.
 * Objective:
 * *******************************************************
 */


public class SurveyResponse {

    /**
     * Validations:
     *  - Enforces non-null fields using @NotNull
     *  - Validates string length with @Length
     *  - Ensures minimum age with @Min
     *  - Checks email format with @Email (custom or framework-based)
     */

    @NotNull
    @Length(min = 3, max = 50)
    private String name;  // Name must be 3–50 characters, not null

    @Min(18)
    private int age; // Age must be at least 18

    @NotNull
    @Email
    private String email; // Email must not be null and must be valid format

    @Length(max = 200)
    private String feedback; // Optional; if present, must be ≤ 200 characters

    /**
     * Constructor for SurveyResponse.
     *
     * @param name     Respondent's name
     * @param age      Respondent's age
     * @param email    Respondent's email address
     * @param feedback Optional feedback text
     */
    public SurveyResponse(String name, int age, String email, String feedback) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.feedback = feedback;
    }
}
