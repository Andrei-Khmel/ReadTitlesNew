package titles;

public class TimeToString {

    public String timeCalculator(int time) {

        int seconds, minutes, hours;
        String secString, minString, temp;

        seconds = time % 60;
        minutes = time / 60 % 60;
        hours = time / 3600;

        if (seconds < 10)
            secString = "0" + seconds;
        else
            secString = String.valueOf(seconds);

        if (minutes < 10)
            minString = "0" + minutes;
        else
            minString = String.valueOf(minutes);        // к часам (в if) нолик не пребавляю т.к. фильмов более 9 часов пока не встречал)))

        temp = "0" + hours + ":" + minString + ":" + secString;

        return temp;
    }
}
