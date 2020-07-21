package titles;

public class LineConverterForIndexNumber extends LineConverter {
    private final int NEXT_NUMBER;

    public LineConverterForIndexNumber(String line, int nextNumber) {
        super(line);
        this.NEXT_NUMBER = nextNumber;
    }
    String convert() {
        int num = Integer.parseInt(line);
        return String.valueOf(num + NEXT_NUMBER);
    }
}
