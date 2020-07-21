package titles;

import java.util.Scanner;

public class InputIndexNumberShift {

    public static int makeInput() {
        int pointsToShift = 0;
        boolean continueInput = true;

        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Please input number of points to shift Index: ");
                pointsToShift = input.nextInt();
                System.out.printf("Index Number will be shifted %04d points \n", pointsToShift);
                continueInput = false;
            } catch (Exception e) {
                System.out.println("(!) Incorrect input. An integer is required.");
                System.out.println("Please try again.");
            }
        } while (continueInput);

        return pointsToShift;
    }
}
