package com.example.first.hw_adapter_03_03_20.pojo;


public class Family extends Person {

    public Family() {
        super("Family Name");
        this.phone = "family number";
    }

    @Override
    String getType() {
        return "Family";
    }


}
