package main.java.com.globant.globersity.model;

public abstract class Teacher implements Payable{
    private static int idCounter = 0;
    private int id;
    private String name;
    private int baseSalary;

    public Teacher(String name, int baseSalary) {
        idCounter += 1;
        id = idCounter;
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

    public abstract int getFinalSalary();

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nbase salary: " + baseSalary;
    }
}
