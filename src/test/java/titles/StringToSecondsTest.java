package titles;

import org.junit.Assert;
import org.junit.Test;

public class StringToSecondsTest {

    @Test
    public void test_ConvertFromStringToSeconds_0() {
        Assert.assertEquals(0, StringToSeconds.convertFromStringToSeconds("00:00:00,400 --> 00:00:00,358", 0));
    }

    @Test
    public void test_ConvertFromStringToSeconds_1() {
        Assert.assertEquals(22, StringToSeconds.convertFromStringToSeconds("00:00:22,400 --> 00:00:25,358", 0));
    }

    @Test
    public void tes_tConvertFromStringToSeconds_2() {
        Assert.assertEquals(25, StringToSeconds.convertFromStringToSeconds("00:00:22,400 --> 00:00:25,358", 17));
    }

    @Test
    public void test_ConvertFromStringToSeconds_3() {
        Assert.assertEquals(6689, StringToSeconds.convertFromStringToSeconds("00:00:22,400 --> 01:51:29,358", 17));
    }
}
