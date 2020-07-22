package titles;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LineConverterForTimeCodeTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test_convert_1() {
        Converter timeCodeConverter = context.getBean("timeConverter", Converter.class);
        Assert.assertEquals("00:00:00,000 --> 00:00:00,000",
                timeCodeConverter.convert("00:00:00,000 --> 00:00:00,000", 0));
    }

    @Test
    public void test_convert_2() {
        Converter timeCodeConverter = context.getBean("timeConverter", Converter.class);
        Assert.assertEquals("00:00:05,000 --> 00:00:05,000",
                timeCodeConverter.convert("00:00:00,000 --> 00:00:00,000", 5));
    }

    @Test
    public void test_convert_3() {
        Converter timeCodeConverter = context.getBean("timeConverter", Converter.class);
        Assert.assertEquals("00:01:01,000 --> 00:01:01,000",
                timeCodeConverter.convert("00:00:00,000 --> 00:00:00,000", 61));
    }
}
