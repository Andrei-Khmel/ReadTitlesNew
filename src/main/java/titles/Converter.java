package titles;

public class Converter<T> {
    private final T LINE_CONVERTER;

    public Converter(T lineConverter) {
        LINE_CONVERTER = lineConverter;
    }

    public T getLineConverter() {
        return LINE_CONVERTER;
    }
}
