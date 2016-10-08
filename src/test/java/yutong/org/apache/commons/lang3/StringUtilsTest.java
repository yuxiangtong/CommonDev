package yutong.org.apache.commons.lang3;

import static org.junit.Assert.*;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


/**
 * StringUtils 测试类
 * 
 * @author yuxiangtong
 *
 */
public class StringUtilsTest {

    @Test
    public void testUpperCase() {
        assertNull(StringUtils.upperCase(null));
        assertNull(StringUtils.upperCase(null, Locale.ENGLISH));
        assertEquals("upperCase(String) failed", "FOO TEST THING",
                StringUtils.upperCase("fOo test THING"));
        assertEquals("upperCase(empty-string) failed", "",
                StringUtils.upperCase(""));
        assertEquals("upperCase(String, Locale) failed", "FOO TEST THING",
                StringUtils.upperCase("fOo test THING", Locale.ENGLISH));
        assertEquals("upperCase(empty-string, Locale) failed", "",
                StringUtils.upperCase("", Locale.ENGLISH));
    }


    @Test
    public void testLowerCase() {
        assertNull(StringUtils.lowerCase(null));
        assertNull(StringUtils.lowerCase(null, Locale.ENGLISH));
        assertEquals("lowerCase(String) failed", "foo test thing",
                StringUtils.lowerCase("fOo test THING"));
        assertEquals("lowerCase(empty-string) failed", "",
                StringUtils.lowerCase(""));
        assertEquals("lowerCase(String, Locale) failed", "foo test thing",
                StringUtils.lowerCase("fOo test THING", Locale.ENGLISH));
        assertEquals("lowerCase(empty-string, Locale) failed", "",
                StringUtils.lowerCase("", Locale.ENGLISH));
    }
}
