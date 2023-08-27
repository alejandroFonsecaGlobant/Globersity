package main.java.com.globant.globersity.model;

public class PartTimeTeacher extends Teacher {
    private final int weeklyHours;
    public PartTimeTeacher (String name, int baseSalary, int weeklyHours) {
        super(name, baseSalary);
        this.weeklyHours = weeklyHours;
    }
    @Override
    public int getFinalSalary() {
        return getBaseSalary() * weeklyHours;
    }

    @Override
    public String toString() {
        String toString = super.toString();
        return toString + "\nweekly hours: " + weeklyHours +
                "\nfinal salary: " + getFinalSalary();
    }
}