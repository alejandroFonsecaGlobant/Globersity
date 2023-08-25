package main.java.com.globant.globersity.ui;

import main.java.com.globant.globersity.model.*;
import main.java.com.globant.globersity.utils.Display;

public class Main {

    public static void main(String[] args) {
        University globersity = new University();
        init(globersity);
    }

    public static void init (University university) {
        FullTimeTeacher full1 = new FullTimeTeacher("Obi-Wan Kenobi",1000000,2);
        university.storeTeacher(full1);
        FullTimeTeacher full2 = new FullTimeTeacher("Lord Sidius",1750000,4);
        university.storeTeacher(full2);
        PartTimeTeacher part1 = new PartTimeTeacher("Darth Vader", 1000000, 5);
        university.storeTeacher(part1);
        PartTimeTeacher part2 = new PartTimeTeacher("Han Solo", 2000000, 8);
        university.storeTeacher(part2);

        university.createStudent("Miles Morales", 18);
        university.createStudent("Pepito Perez", 19);
        university.createStudent("Mary Jane", 21);
        university.createStudent("John Wick", 18);
        university.createStudent("Mike Wazowski", 25);
        university.createStudent("Giovanni Girogio", 23);

        university.createCourse("Matematicas III", "E406");
        university.assignTeacherToCourse(1,1);
        university.enlistStudentToCourse(1,1);
        university.enlistStudentToCourse(2,1);

        university.createCourse("Estimación de tests", "D108");
        university.assignTeacherToCourse(3,2);
        university.enlistStudentToCourse(3,2);
        university.enlistStudentToCourse(4,2);

        university.createCourse("Algoritmos de programación", "C210");
        university.assignTeacherToCourse(2,3);
        university.enlistStudentToCourse(5,3);
        university.enlistStudentToCourse(6,3);

        university.createCourse("Photoshop avanzado", "F101");
        university.assignTeacherToCourse(4,4);
        university.enlistStudentToCourse(1,4);
        university.enlistStudentToCourse(4,4);
    }
}