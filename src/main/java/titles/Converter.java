package titles;

public class Converter {
    private LineConverter lineConverter;

    public Converter(LineConverter lineConverter) {
        this.lineConverter = lineConverter;
    }

    public String convert(String line, int shift) {
        return lineConverter.convert(line, shift);
    }
}
