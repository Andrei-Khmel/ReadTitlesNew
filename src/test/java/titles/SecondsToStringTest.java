package titles;

import org.junit.Assert;
import org.junit.Test;

public class SecondsToStringTest {

    @Test
    public void testTimeCalculator0() {
        Assert.assertEquals("00:00:00", SecondsToString.convertFromSecondsToString(0));
    }

    @Test
    public void testTimeCalculator1() {
        Assert.assertEquals("00:00:01", SecondsToString.convertFromSecondsToString(1));
    }

    @Test
    public void testTimeCalculator2() {
        Assert.assertEquals("00:01:00", SecondsToString.convertFromSecondsToString(60));
    }

    @Test
    public void testTimeCalculator3() {
        Assert.assertEquals("01:00:00", SecondsToString.convertFromSecondsToString(3600));
    }

    @Test
    public void testTimeCalculator4() {
        Assert.assertEquals("01:51:29", SecondsToString.convertFromSecondsToString(6689));
    }

    @Test
    public void testTimeCalculator6() {
        Assert.assertEquals("596523:14:07",
                SecondsToString.convertFromSecondsToString(Integer.MAX_VALUE));
    }
}