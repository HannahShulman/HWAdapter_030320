package com.example.first.hw_adapter_03_03_20;

public class Friend extends Person {

    public Friend() {
        this.name = "Friend Name";
        this.phone = "phone number";
    }

    @Override
    String getType() {
        return "FRIEND";
    }
}
