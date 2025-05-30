package com.surveyvalidator;


/**
 * *******************************************************
 * Package: com.surveyvalidator
 * File: App.java
 * Author: Ochwada
 * Date: Tuesday, 27.May.2025, 2:20 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public class App {
    public static void main(String[] args) {
        System.out.println("\uD83C\uDF40 Survey Validator");

        SurveyResponse r1 = new SurveyResponse("John", 25, "john@example.com", "Great survey!");
        SurveyResponse r2 = new SurveyResponse(null, 17, "invalidemail", "Very informative.");

        try {
            Validator.validate(r1);
        }catch (Exception e){
            System.err.println("❌ r1 Error: " + e.getMessage());
        }

        try{
            Validator.validate(r2);
        } catch (Exception e) {
            System.err.println("❌ r2 Error: " + e.getMessage());
        }
    }
}
