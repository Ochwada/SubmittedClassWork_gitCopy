package org.supplychain.items;


/**
 * *******************************************************
 * Package: org.supplychain.items
 * File: Electronic.java
 * Author: Ochwada
 * Date: Monday, 28.Apr.2025, 5:25 PM
 * Description:Subclass representing electronic products - override getType
 * Objective:
 * *******************************************************
 */

public class Electronic extends Product {

    public Electronic(String id, String name){
        super(id, name);
    }

    @Override
    public String getType(){
        return  "Electronic";
    }
}
