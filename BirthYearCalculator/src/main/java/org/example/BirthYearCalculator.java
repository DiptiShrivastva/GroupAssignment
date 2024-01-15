package org.example;

import java.util.Scanner;
import java.util.Calendar;

public class BirthYearCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name");
        String name = scanner.nextLine();
        System.out.print("Enter the age: ");
        String age = scanner.nextLine();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        YearCalculator yearCalculator = new YearCalculator();
        int birthYear = yearCalculator.calculateBirthYear(currentYear, age);
        if (birthYear < 0) {
            System.out.println("invalid age");
        } else {
            System.out.println(yearCalculator.printGreetings(name, birthYear));
        }
    }
}

