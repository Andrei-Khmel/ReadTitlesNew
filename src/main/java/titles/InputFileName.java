package titles;

import java.io.File;
import java.util.Scanner;

public class InputFileName {

    static String makeInput() {
        String fileName;
        boolean continueInput = true;

        do {
            System.out.print("\nPlease input file name: ");
            Scanner input = new Scanner(System.in);
            fileName = input.nextLine();

            File checkFile = new File(fileName);
            if (!checkFile.isFile()) {
                System.out.printf("(!) The entered File Name (%s) does not exist.\n", fileName);
                System.out.println("Please be sure to enter correct file name.");
            } else {
                continueInput = false;
            }
        } while (continueInput);

        return fileName;
    }
}
