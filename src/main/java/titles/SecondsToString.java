package titles;

public class SecondsToString {

    static String convertFromSecondsToString(int timeInSeconds) {

        final int TIME_UNIT = 60;
        int seconds = timeInSeconds % TIME_UNIT;
        int minutes = timeInSeconds / TIME_UNIT % TIME_UNIT;
        int hours = timeInSeconds / (TIME_UNIT * TIME_UNIT);

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
