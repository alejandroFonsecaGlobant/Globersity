package main.java.com.globant.globersity.ui;

import main.java.com.globant.globersity.model.FullTimeTeacher;
import main.java.com.globant.globersity.model.PartTimeTeacher;
import main.java.com.globant.globersity.utils.Display;

public class Main {
    public static void main(String[] args) {
        FullTimeTeacher full1 = new FullTimeTeacher("Obi-Wan Kenobi",1000000,2);
        FullTimeTeacher full2 = new FullTimeTeacher("Lord Sidius",1750000,4);
        PartTimeTeacher part1 = new PartTimeTeacher("Darth Vader", 1000000, 5);
        PartTimeTeacher part2 = new PartTimeTeacher("Han Solo", 2000000, 8);
        System.out.println(full1.toString() + "\n" + Display.TEXT_DIVISOR);
        System.out.println(full2.toString() + "\n" + Display.TEXT_DIVISOR);
        System.out.println(part1.toString() + "\n" + Display.TEXT_DIVISOR);
        System.out.println(part2.toString());
    }
}
