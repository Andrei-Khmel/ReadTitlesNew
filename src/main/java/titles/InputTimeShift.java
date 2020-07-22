package titles;

import java.util.Scanner;

public class InputTimeShift {

    static Integer makeInput() {
        int seconds = 0;
        boolean continueInput = true;

        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Please input Time Shift in seconds: ");
                seconds = input.nextInt();
                System.out.println("Time Shift entered as " + SecondsToString.convertFromSecondsToString(seconds));
                continueInput = false;
            } catch (Exception e) {
                System.out.println("(!) Incorrect input. An integer is required.");
                System.out.println("Please try again.");
            }
        } while (continueInput);
        return seconds;
    }
}
