package Pojo;

public class Family extends Person {

    public Family() {
        this.name = "family name";
        this.phone = "family phone";
    }

    @Override
    String getType() {
        return "FAMILY";
    }
}
