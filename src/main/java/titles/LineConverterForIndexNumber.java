package titles;

public class LineConverterForIndexNumber implements LineConverter {
    @Override
    public String convert(String line, int nextNumber) {
        int num = Integer.parseInt(line);
        return String.valueOf(num + nextNumber);
    }
}
