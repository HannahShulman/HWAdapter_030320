package Pojo;



public class Student extends Person{

    String course;
    double avarage;

    public Student(String course, double avarage) {
        super("Student Name");
        this.phone = "random phone number";
        this.course = course;
        this.avarage = avarage;
    }

    @Override
    String getType() {
        return "STUDENT";
    }
}
