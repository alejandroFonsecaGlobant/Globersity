package main.java.com.globant.globersity.model;

import main.java.com.globant.globersity.utils.Display;

import java.util.ArrayList;

public class Course {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String classroom;
    private ArrayList<Student> students;
    private Teacher teacher;

    public Course (String name, String classroom){
        idCounter += 1;
        id = idCounter;
        this.name = name;
        this.classroom = classroom;
        students = new ArrayList<Student>();
    }

    public boolean enlistStudent(Student student){
        boolean isAdded = false;
        if (!students.contains(student)) {
            isAdded = true;
            students.add(student);
        }
        return isAdded;
    }

    public boolean isStudentEnrolled(Student student){
        boolean enrolled = false;

        if (students.contains(student)) {
            enrolled = true;
        }
        return enrolled;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nclassroom: " + classroom +
                "\nstudents enlisted: " + students.size();
    }

    public String studentsToString() {
        StringBuilder toString = new StringBuilder();
        for (Student student:students) {
            toString.append(student.toString()).append("\n")
                    .append(Display.TEXT_DIVISOR).append("\n");
        }
        return toString.toString();
    }

    public String teacherToString() {
        return teacher.toString();
    }

    public int getId() {
        return id;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
