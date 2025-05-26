package org.supplychain.items;


/**
 * *******************************************************
 * Package: org.supplychain.items
 * File: Document.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 5:24 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class Document extends Product {

    public Document(String id, String name){
        super(id, name);
    }

    @Override
    public String getType(){
        return "Document";
    }
}
