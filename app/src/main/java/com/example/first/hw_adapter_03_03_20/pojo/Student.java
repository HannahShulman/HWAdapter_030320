package com.example.first.hw_adapter_03_03_20.pojo;

public class Student extends Person {
    String course;
    double average;

    public Student(String course, double average) {
        super("student Name");
        this.phone = "some phone number";
        this.course = course;
        this.average = average;
    }

    @Override
    String getType() {
        return "STUDENT";
    }
}
