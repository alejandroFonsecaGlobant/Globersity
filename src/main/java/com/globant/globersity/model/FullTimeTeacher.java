package main.java.com.globant.globersity.model;

public class FullTimeTeacher extends Teacher {
    private final int experienceYears;
    public FullTimeTeacher(String name, int baseSalary, int experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }
    @Override
    public int getFinalSalary() {
        return (int) (getBaseSalary() * (Payable.YEAR_MULTIPLIER * experienceYears));
    }

    @Override
    public String toString() {
        String toString = super.toString();
        return toString + "\nexperience years: " + experienceYears +
                "\nfinal salary: " + getFinalSalary();
    }
}
