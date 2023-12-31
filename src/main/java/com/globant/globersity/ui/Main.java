package main.java.com.globant.globersity.ui;

import main.java.com.globant.globersity.model.*;
import main.java.com.globant.globersity.utils.Display;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        University globersity = new University();
        init(globersity);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        try {
            System.out.println("Welcome to Globersity Manager");
            while (!exit) {
                System.out.println("Write the number of the option you want to do:\n1 - Create a student" +
                        "\n2 - Create a course\n3 - Show all registered teachers\n" +
                        "4 - Show all registered courses\n5 - Show courses from a student" +
                        "\n6 - Exit");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        Student student = createStudent(scanner, globersity);
                        if (student != null) {
                            boolean enlisted = false;
                            while (!enlisted) {
                                enlisted = enlistStudentToCourse(scanner, globersity, student);
                            }
                        }
                        break;

                    case 2:
                        Course course = createCourse(scanner, globersity);
                        if (course != null) {
                            boolean done = false;
                            while (!done) {
                                done = assignTeacherToCourse(scanner,globersity,course.getId());
                            }

                            done = false;
                            while (!done) {
                                boolean enlisted = enlistStudentToCourse(scanner,globersity,course.getId());
                                if (enlisted) {
                                    System.out.println("Enlist another student?\n1 - Yes\n2 - No");
                                    int decision = Integer.parseInt(scanner.nextLine());
                                    if (decision == 2) {
                                        done = true;
                                    }
                                }
                            }
                        }
                        System.out.println(globersity.displayCourseData(5));
                        break;

                    case 3:
                        System.out.println(globersity.displayAllTeachers());
                        break;

                    case 4:
                        System.out.println(globersity.displayAllCourses());
                        break;

                    case 5:
                        System.out.println("Enter the id of the student to obtain course from (greater than 0):");
                        try {
                            int id = Integer.parseInt(scanner.nextLine());
                            String courses = globersity.displayStudentCourses(id);
                            if (courses.equalsIgnoreCase(Display.COURSES_HEAD + "\n")) {
                                System.out.println("The student with id " + id + " is not enlisted to any course");
                            } else {
                                System.out.println(courses);
                            }
                        } catch (Exception e) {
                            System.out.println(Display.INPUT_ERROR);
                        }
                        break;

                    case 6:
                        System.out.println("Shutting down...");
                        exit = true;
                        break;

                    default:
                        System.out.println(Display.INPUT_ERROR);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(Display.INPUT_ERROR);
        }
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

    public static Student createStudent(Scanner scanner, University university) {
        try {
            System.out.println(Display.CREATE_STUDENT_HEAD);

            System.out.println("Enter the name of the student (Not empty):");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                throw new InputMismatchException();
            }

            System.out.println("Enter the age of the student (Greater than 0):");
            int age = Integer.parseInt(scanner.nextLine());
            if (age <= 0) {
                throw new InputMismatchException();
            }

            Student student = university.createStudent(name, age);
            System.out.println("Student created with id no. " + student.getId());
            return student;

        } catch (Exception e) {
            System.out.println(Display.INPUT_ERROR);
            return null;
        }
    }

    public static boolean enlistStudentToCourse(Scanner scanner, University university, Student student) {
        try {
            System.out.println("Enter the id of the course to enlist the " +
                    "student (0 for exiting without enlisting):");
            boolean enlisted = false;
            int courseId = Integer.parseInt(scanner.nextLine());
            if (courseId == 0) {
                return true;
            } else if (courseId < 0) {
                throw new InputMismatchException();
            }

            enlisted = university.enlistStudentToCourse(student, courseId);
            if (enlisted){
                System.out.println("Student enlisted in course with id no. " + courseId);
            } else {
                System.out.println("Wrong id or student already enlisted to course, try again");
            }
            return enlisted;

        } catch (Exception e) {
            System.out.println(Display.INPUT_ERROR);
            return false;
        }
    }

    public static Course createCourse (Scanner scanner, University university) {
        try {
            System.out.println(Display.CREATE_COURSE_HEAD);

            System.out.println("Enter the name of the course (Not empty):");
            String name = scanner.nextLine();

            System.out.println("Enter the classroom of the course (Not empty):");
            String classroom = scanner.nextLine();
            if (name.isEmpty() || classroom.isEmpty()) {
                throw new InputMismatchException();
            }

            Course course = university.createCourse(name, classroom);
            System.out.println("Course created with id no. " + course.getId());
            return course;

        } catch (Exception e) {
            System.out.println(Display.INPUT_ERROR);
            return null;
        }
    }

    public static boolean assignTeacherToCourse (Scanner scanner, University university, int courseId){
        try {
            System.out.println("Enter the id of the teacher to assign (Greater than 0):");
            boolean assigned = false;
            int teacherId = Integer.parseInt(scanner.nextLine());
            if (teacherId <= 0) {
                throw new InputMismatchException();
            }
            assigned = university.assignTeacherToCourse(teacherId,courseId);
            if (assigned){
                System.out.println("Teacher assigned to course with id no. " + teacherId);
            } else {
                System.out.println("Wrong teacher id, try again");
            }
            return assigned;

        } catch (Exception e) {
            System.out.println(Display.INPUT_ERROR);
            return false;
        }
    }

    public static boolean enlistStudentToCourse(Scanner scanner, University university, int courseId) {
        try {
            System.out.println("Enter the id of the student to enlist (greater than 0):");
            boolean enlisted = false;
            int studentId = Integer.parseInt(scanner.nextLine());
            if (studentId == 0) {
                return true;
            } else if (studentId <= 0) {
                throw new InputMismatchException();
            }

            enlisted = university.enlistStudentToCourse(studentId,courseId);
            if (enlisted){
                System.out.println("Student with id no. "+ studentId +" enlisted in course");
            } else {
                System.out.println("Wrong id or student already enlisted to course, try again");
            }
            return enlisted;

        } catch (Exception e) {
            System.out.println(Display.INPUT_ERROR);
            return false;
        }
    }
}