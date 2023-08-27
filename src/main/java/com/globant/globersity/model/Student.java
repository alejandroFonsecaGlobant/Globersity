package main.java.com.globant.globersity.model;

public class Student {
    public static int idCounter = 0;
    public final int id;
    public String name;
    public int age;

    public Student (String name, int age) {
        idCounter += 1;
        id = idCounter;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nage: " + age;
    }
}
