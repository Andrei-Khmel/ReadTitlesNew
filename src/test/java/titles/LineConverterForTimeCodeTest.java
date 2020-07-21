package titles;

import org.junit.Assert;
import org.junit.Test;

public class LineConverterForTimeCodeTest {

    @Test
    public void test_convert_1() {
        LineConverterForTimeCode lineConverterForTimeCode = new LineConverterForTimeCode("00:00:00,000 --> 00:00:00,000", 0);
        Assert.assertEquals("00:00:00,000 --> 00:00:00,000", lineConverterForTimeCode.convert());
    }

    @Test
    public void test_convert_2() {
        LineConverterForTimeCode lineConverterForTimeCode = new LineConverterForTimeCode("00:00:00,000 --> 00:00:00,000", 5);
        Assert.assertEquals("00:00:05,000 --> 00:00:05,000", lineConverterForTimeCode.convert());
    }

    @Test
    public void test_convert_3() {
        LineConverterForTimeCode lineConverterForTimeCode = new LineConverterForTimeCode("00:00:00,000 --> 00:00:00,000", 61);
        Assert.assertEquals("00:01:01,000 --> 00:01:01,000", lineConverterForTimeCode.convert());
    }
}
