package titles;

public class StringToSeconds {

    static int convertFromStringToSeconds(String line, int firstCharPosition) {
        final int TIME_UNIT = 60;

        int seconds = Integer.parseInt(line.substring(firstCharPosition + 6, firstCharPosition + 8));
        int minutes = Integer.parseInt(line.substring(firstCharPosition + 3, firstCharPosition + 5));
        int hours = Integer.parseInt(line.substring(firstCharPosition, firstCharPosition + 2));

        return seconds + minutes * TIME_UNIT + hours * TIME_UNIT * TIME_UNIT;
    }
}
