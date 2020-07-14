package titles;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeToStringTest {

    TimeToString timeObj = new TimeToString();

    @Test
    public void testTimeCalculator1() {
        Assert.assertEquals("00:00:01", timeObj.timeCalculator(1));
    }

    @Test
    public void testTimeCalculator2() {
        Assert.assertEquals("00:01:00", timeObj.timeCalculator(60));
    }

    @Test
    public void testTimeCalculator3() {
        Assert.assertEquals("01:00:00", timeObj.timeCalculator(3600));
    }

    @Test
    public void testTimeCalculator4() {
        Assert.assertEquals("01:51:29", timeObj.timeCalculator(6689));
    }

    @Test
    public void testTimeCalculator5() {
        Assert.assertEquals("00:50:59", timeObj.timeCalculator(3059));
    }

    @Test
    public void testTimeCalculator6() {
        Assert.assertEquals("00:02:36", timeObj.timeCalculator(156));
    }
}