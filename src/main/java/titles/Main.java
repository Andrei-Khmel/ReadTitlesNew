package titles;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int sec = 11; // сдвиг в  секундах
        int nextNum = 0; // порядковый номер титров (его сдвиг) если приходиться разбивать файл с титрами на две серии например
        String sourceFileName = "orca.srt";
        String destinationFileName = "orca.srt";

        String characterEncoding = "Windows-1251";
        //       String characterEncoding = "UTF-8";

        int h = 0;          // временная точка после которой производится редактирование (часы, мин, сек.)
        int m = 12;
        int s = 0;

        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedFile = null;
        String outFile = "";
        BufferedWriter writer;
        FileWriter fileWriter;

        TimeToString tempString = new TimeToString();

        try {
            bufferedFile = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFileName), characterEncoding));
        } catch (Exception e) {
            System.out.println("\n....txt file has not been found ...creating file");
        }
        Scanner fromBuff;
        try {
            fromBuff = new Scanner(bufferedFile);
            while (fromBuff.hasNextLine()) {
                String line = fromBuff.nextLine();
                list.add(line);
            }
            bufferedFile.close();
        } catch (Exception e) {
            System.out.println("no data to load from new file");
        }

        for (int i = 0; i < list.size(); i++) {
            int hours, minutes, seconds, time;
            String tmp;
            if (list.get(i).length() > 20 && ((list.get(i).substring(0, 2).equals("00")) || (list.get(i).substring(0, 2).equals("01"))) &&
                    (Integer.parseInt(list.get(i).substring(0, 2)) * 3600 + Integer.parseInt(list.get(i).substring(3, 5)) * 60 +
                            Integer.parseInt(list.get(i).substring(6, 8)) > h * 3600 + m * 60 + s)) {
                // строка с кодом времени начала и окончания показа титров. Как правило начинается "00" или "01" (паказания кол-ва часов)
                // имеект ограниченную длину

                seconds = Integer.parseInt(list.get(i).substring(6, 8));      // время начала показа титров
                minutes = Integer.parseInt(list.get(i).substring(3, 5));
                hours = Integer.parseInt(list.get(i).substring(0, 2));

                time = seconds + minutes * 60 + hours * 3600 + sec;    // общее время переведено в секунды и прибавлено время сдвига

                String temp1 = tempString.timeCalculator(time);         // вызов функции формирования нового стринга для пересчитанного времени
                temp1 = temp1 + "," + list.get(i).substring(9, 12);         // в позиции 9-12 какието микросекунды??? я их не трогал

                seconds = Integer.parseInt(list.get(i).substring(23, 25));       // временя окончания показа титров
                minutes = Integer.parseInt(list.get(i).substring(20, 22));
                hours = Integer.parseInt(list.get(i).substring(17, 19));

                time = seconds + minutes * 60 + hours * 3600 + sec;     // общее время переведено в секунды и прибавлено время сдвига

                String temp2 = tempString.timeCalculator(time);             // снова функция формирования текста, только для времени окончания показа
                temp2 = temp2 + "," + list.get(i).substring(26, 29);

                tmp = temp1 + " --> " + temp2;                          // формируется готовая строка с исправленным временем
                list.set(i, tmp);

            } else if (list.get(i).length() < 4 && list.get(i).matches("\\d+")) {    // строка с порядковым номером = число от 1 до 999
                hours = Integer.parseInt(list.get(i));         // в блоке выше hours - это часы. Здесь порятковый номер титров))).
                tmp = String.valueOf(hours + nextNum);                      // для экономии переменных))).
                list.set(i, tmp);
            }
            outFile = outFile + list.get(i) + "\n";
        }
        System.out.println(outFile);

        try {
            fileWriter = new FileWriter(destinationFileName);
            writer = new BufferedWriter(fileWriter);
            assert outFile != null;
            writer.write(outFile);
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
