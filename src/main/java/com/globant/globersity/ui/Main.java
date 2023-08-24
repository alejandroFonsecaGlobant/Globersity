package main.java.com.globant.globersity.ui;

import main.java.com.globant.globersity.model.Course;
import main.java.com.globant.globersity.model.FullTimeTeacher;
import main.java.com.globant.globersity.model.PartTimeTeacher;
import main.java.com.globant.globersity.model.Student;
import main.java.com.globant.globersity.utils.Display;

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init () {
        FullTimeTeacher full1 = new FullTimeTeacher("Obi-Wan Kenobi",1000000,2);
        FullTimeTeacher full2 = new FullTimeTeacher("Lord Sidius",1750000,4);
        PartTimeTeacher part1 = new PartTimeTeacher("Darth Vader", 1000000, 5);
        PartTimeTeacher part2 = new PartTimeTeacher("Han Solo", 2000000, 8);

        Student student1 = new Student("Miles Morales",18);
        Student student2 = new Student("Pepito Perez",19);
        Student student3 = new Student("Mary Jane",21);
        Student student4 = new Student("John Wick",18);
        Student student5 = new Student("Mike Wazowski",25);
        Student student6 = new Student("Giovanni Giorgio",23);

        Course course1 = new Course("Matematicas III","E406");
        course1.setTeacher(full1);
        course1.enlistStudent(student1);
        course1.enlistStudent(student2);

        Course course2 = new Course("Estimación de tests", "D108");
        course2.setTeacher(part1);
        course2.enlistStudent(student3);
        course2.enlistStudent(student4);

        Course course3 = new Course("Algoritmos de programación","C210");
        course3.setTeacher(full2);
        course3.enlistStudent(student5);
        course3.enlistStudent(student6);

        Course course4 = new Course("Photoshop avanzado", "F101");
        course4.setTeacher(part2);
        course4.enlistStudent(student1);
        course4 .enlistStudent(student4);
    }
}