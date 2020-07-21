package titles;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int timeShiftInSeconds = InputTimeShift.makeInput();
        int indexNumberShift = InputIndexNumberShift.makeInput();
        int startingPointInSeconds = InputEditStartingPoint.makeInput();
        String fileName = InputFileName.makeInput();

        ArrayList<String> list = new ArrayList<>();
        FileReader.readFile(fileName, list);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            int maxNumberOfDigits = 4;

            if ((list.get(i).startsWith("-->", 13)) &&
                    (StringToSeconds.convertFromStringToSeconds(list.get(i), 0) > startingPointInSeconds)) {

                Converter<LineConverterForTimeCode> converter = new Converter<>(new LineConverterForTimeCode(list.get(i), timeShiftInSeconds));
                list.set(i, converter.getLineConverter().convert());

            } else if (list.get(i).length() < maxNumberOfDigits && list.get(i).matches("\\d+") && indexNumberShift != 0) {

                Converter<LineConverterForIndexNumber> converter = new Converter<>(new LineConverterForIndexNumber(list.get(i), indexNumberShift));
                list.set(i, converter.getLineConverter().convert());
            }
            stringBuilder.append(list.get(i)).append("\n");
        }
        System.out.println(stringBuilder);

        StringBackToFile.writeFile(fileName, stringBuilder.toString());
    }
}
