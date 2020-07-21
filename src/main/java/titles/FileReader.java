package titles;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static void readFile(String sourceFileName, ArrayList<String> list) {

        Scanner scannedFile = null;
        try {
            scannedFile = new Scanner(new File(sourceFileName));
        } catch (Exception e) {
            System.out.printf("\n.... %s file has not been found. \n", sourceFileName);
        }

        while (true) {
            assert scannedFile != null;
            if (!scannedFile.hasNextLine()) break;
            list.add(scannedFile.nextLine());
        }
    }
}
