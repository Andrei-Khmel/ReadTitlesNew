package titles;

import org.junit.Assert;
import org.junit.Test;

public class LineConverterForIndexNumberTest {

    @Test
    public void test_convert_1() {
        LineConverterForIndexNumber convertIndexNumber = new LineConverterForIndexNumber("1", 30);
        Assert.assertEquals("31", convertIndexNumber.convert());
    }

    @Test
    public void test_convert_2() {
        LineConverterForIndexNumber convertIndexNumber = new LineConverterForIndexNumber("241", -30);
        Assert.assertEquals("211", convertIndexNumber.convert());
    }

    @Test
    public void test_convert_3() {
        LineConverterForIndexNumber convertIndexNumber = new LineConverterForIndexNumber("1", 0);
        Assert.assertEquals("1", convertIndexNumber.convert());
    }
}
