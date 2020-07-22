package titles;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LineConverterForIndexNumberTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test_convert_1() {
        Converter indexConverter = context.getBean("indexConverter", Converter.class);
        Assert.assertEquals("31", indexConverter.convert("1", 30));
    }

    @Test
    public void test_convert_2() {
        Converter indexConverter = context.getBean("indexConverter", Converter.class);
        Assert.assertEquals("211", indexConverter.convert("241", -30));
    }

    @Test
    public void test_convert_3() {
        Converter indexConverter = context.getBean("indexConverter", Converter.class);
        Assert.assertEquals("1", indexConverter.convert("1", 0));
        context.close();
    }
}
