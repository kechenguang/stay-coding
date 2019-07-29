package rpc;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private int age;
    private String location;
    private transient String gender;
    private static final long serialVersionUID = -6849794470754667710L;


    public User(String name, int age, String location, String gender) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        builder.append("+");
        builder.append(this.age);
        builder.append("+");
        builder.append(this.location);
        builder.append("+");
        builder.append(this.gender);
        return builder.toString();
    }
}
