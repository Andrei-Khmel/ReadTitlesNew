package titles;

import org.junit.Assert;
import org.junit.Test;

public class LineConverterTest {

    @Test
    public void test_ConstructorInput_1() {
        LineConverter lineConverter = new LineConverter("00:00:00,000 --> 00:00:00,000");
        Assert.assertEquals("00:00:00,000 --> 00:00:00,000", lineConverter.line);
    }

    @Test
    public void test_ConstructorInput_2() {
        LineConverter lineConverter = new LineConverter("01:01:01,000 --> 01:01:07,000");
        Assert.assertEquals("01:01:01,000 --> 01:01:07,000", lineConverter.line);
    }
}
