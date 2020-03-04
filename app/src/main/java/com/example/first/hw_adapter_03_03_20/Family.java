package com.example.first.hw_adapter_03_03_20;

public class Family extends Person {

    public Family() {
        this.name = "Family Name";
        this.phone = "family number";
    }

    @Override
    String getType() {
        return "Family";
    }
}
