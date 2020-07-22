package titles;

public class LineConverterForTimeCode implements LineConverter {
    @Override
    public String convert(String line, int timeShift){
        int timeInSeconds;
        String tmp;

        timeInSeconds = StringToSeconds.convertFromStringToSeconds(line, 0)  + timeShift;    // a tittle start time (time fora a given tittle to appear) converted to seconds + time shift added;
        tmp = SecondsToString.convertFromSecondsToString(timeInSeconds) + "," + line.substring(9, 12);         // character positions 9-12 (26-29) contain mkSeconds (or something) that have not been taken into account;
        timeInSeconds = StringToSeconds.convertFromStringToSeconds(line, 17) + timeShift;     // a tittle end time (time when it disappears from screen) + time shift added;
        return tmp + " --> " + SecondsToString.convertFromSecondsToString(timeInSeconds) + "," + line.substring(26, 29);
        }
}
