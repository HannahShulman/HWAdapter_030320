package com.example.first.hw_adapter_03_03_20.pojo;


public class Friend extends Person {

    public Friend() {
        super("Friend Name");
        this.phone = "phone number";
    }

    @Override
    public String getType() {
        return "friend";
    }
}
