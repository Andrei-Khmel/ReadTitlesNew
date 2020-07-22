package titles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StringBackToFile {

    public static void writeFile (String destinationFileName, String outFile){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName));
            assert outFile != null;
            writer.write(outFile);
            writer.close();
        } catch (
                IOException e1) {
            e1.printStackTrace();
        }
    }
}
