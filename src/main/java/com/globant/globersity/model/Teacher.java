package main.java.com.globant.globersity.model;

public abstract class Teacher {
    private static int ID_COUNTER = 0;
    private int id;
    private String name;
    private int baseSalary;
    private int finalSalary;

    public Teacher(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public int getFinalSalary() {
        return finalSalary;
    }
}
