package Pojo;

import java.util.ArrayList;

import Pojo.Person;
import Pojo.Teacher;

public class Manager extends Person {

    ArrayList<Teacher> teachers = new ArrayList<>();

    @Override
    String getType() {
        return null;
    }
}
