package Pojo;

import java.util.ArrayList;

public class Teacher extends Person {

    ArrayList<Student> students = new ArrayList<>();

    @Override
    String getType() {
        return "TEACHER";
    }
}
