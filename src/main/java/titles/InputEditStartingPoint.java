package titles;

import java.util.Scanner;

public class InputEditStartingPoint {

    static int makeInput() {
        final int TIME_UNIT = 60;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        boolean continueInput = true;

        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Please input Edit Start Time as \"hh mm ss\":");
                hours = input.nextInt();
                minutes = input.nextInt();
                seconds = input.nextInt();
                if (!(hours < 60) || !(minutes < 60) || !(seconds < 60) || hours < 0 || minutes < 0 || seconds < 0) {
                    System.out.println("(!) hours (hh), minutes (mm) or seconds (ss) all should be positive numbers between 0 and 59");
                    continue;
                }
                System.out.printf("Edit Start Time entered as %02d:%02d:%02d ", hours, minutes, seconds);
                continueInput = false;
            } catch (Exception e) {
                System.out.println("(!) Incorrect input. An integer is required.");
                System.out.println("Please try again.");
            }
        } while (continueInput);
        return seconds + minutes * TIME_UNIT + hours * TIME_UNIT * TIME_UNIT;
    }
}
