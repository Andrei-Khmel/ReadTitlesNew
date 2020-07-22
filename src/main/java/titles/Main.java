package titles;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
            int maxOfIndexDigits = 4;
            int firstDashOfArrowPosition = 13;
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

            if ((list.get(i).startsWith("-->", firstDashOfArrowPosition)) &&
                    (StringToSeconds.convertFromStringToSeconds(list.get(i), 0) > startingPointInSeconds)) {

                Converter timeConverter = context.getBean("timeConverter", Converter.class);
                list.set(i, timeConverter.convert(list.get(i), timeShiftInSeconds));

            } else if (list.get(i).length() < maxOfIndexDigits && list.get(i).matches("\\d+") && indexNumberShift != 0) {

                Converter indexConverter = context.getBean("indexConverter", Converter.class);
                list.set(i, indexConverter.convert(list.get(i), indexNumberShift));
            }
            stringBuilder.append(list.get(i)).append("\n");
            context.close();
        }
        System.out.println(stringBuilder);

        StringBackToFile.writeFile(fileName, stringBuilder.toString());
    }
}
