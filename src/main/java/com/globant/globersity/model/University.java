package main.java.com.globant.globersity.model;

import main.java.com.globant.globersity.utils.Display;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class University {
    ArrayList<Student> students;
    ArrayList<Teacher> teachers;
    ArrayList<Course> courses;

    public University () {
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
        courses = new ArrayList<Course>();
    }

    public String displayAllTeachers() {
        StringBuilder toString = new StringBuilder();
        toString.append(Display.TEACHERS_HEAD).append("\n");
        for (Teacher teacher:
             teachers) {
            toString.append(teacher.toString()).append("\n")
                    .append(Display.TEXT_DIVISOR).append("\n");
        }
        return toString.toString();
    }

    public String displayAllCourses() {
        StringBuilder toString = new StringBuilder();
        toString.append(Display.COURSES_HEAD).append("\n");
        for (Course course:
                courses) {
            toString.append(course.toString()).append("\n")
                    .append(Display.TEXT_DIVISOR).append("\n");
        }
        return toString.toString();
    }

    public String displayCourseData(int id) {
        String courseData = "";
        if (id <= courses.size()){
            Course course = courses.get(id-1);
            courseData = Display.COURSE_DATA_HEAD + "\n" + course.toString()
                    + "\n" + Display.TEACHER_HEAD
                    + "\n" + course.teacherToString() + "\n" + Display.STUDENTS_HEAD
                    + "\n" + course.studentsToString();
        }
        return courseData;
    }

    public Student createStudent(String name, int age) {
        Student student = new Student(name, age);
        students.add(student);
        return student;
    }

    public Course createCourse(String name, String classroom) {
        Course course = new Course(name, classroom);
        courses.add(course);
        return course;
    }

    public void storeTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean enlistStudentToCourse(Student student, int courseId) {
        boolean isAdded = false;
        Course course;
        if (courseId <= courses.size()) {
            course = courses.get(courseId - 1);
            isAdded = course.enlistStudent(student);
        }
        return isAdded;
    }

    public boolean enlistStudentToCourse(int studentId, int courseId) {
        boolean isAdded = false;
        Course course;
        Student student;
        if (studentId <= students.size() && courseId <= courses.size()) {
            course = courses.get(courseId - 1);
            student = students.get(studentId - 1);
            isAdded = course.enlistStudent(student);
        }
        return isAdded;
    }

    public boolean assignTeacherToCourse(int teacherId, int courseId) {
        boolean isAssigned = false;
        Teacher teacher;
        Course course;
        if (teacherId <= teachers.size() && courseId <= courses.size()) {
            teacher = teachers.get(teacherId - 1);
            course = courses.get(courseId - 1);
            course.setTeacher(teacher);
            isAssigned = true;
        }
        return isAssigned;
    }

    public String displayStudentCourses(int id) {
        StringBuilder toString = new StringBuilder();
        toString.append(Display.COURSES_HEAD).append("\n");
        if (id <= students.size()) {
            Student student = students.get(id-1);
            for (Course course:
                 courses) {
                if (course.isStudentEnrolled(student)) {
                    toString.append(course.toString()).append("\n")
                            .append(Display.TEXT_DIVISOR).append("\n");
                }
            }
        }
        return toString.toString();
    }
}
