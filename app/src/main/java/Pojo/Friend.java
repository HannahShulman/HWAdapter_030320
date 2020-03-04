package Pojo;

public class Friend extends Person {

    public Friend() {
        super("Friend Name");
        this.phone = "Friend phone";
    }

    @Override
    String getType() {
        return "FRIEND";
    }
}
