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
@SuppressWarnings("deprecation") // deliberate use of deprecated code
public class StringUtilsTest {

    static final String WHITESPACE;

    static final String NON_WHITESPACE;

    static final String HARD_SPACE;

    static final String TRIMMABLE;

    static final String NON_TRIMMABLE;

    static {
        String ws = "";
        String nws = "";
        final String hs = String.valueOf(((char) 160));
        String tr = "";
        String ntr = "";
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            if (Character.isWhitespace((char) i)) {
                ws += String.valueOf((char) i);
                if (i > 32) {
                    ntr += String.valueOf((char) i);
                }
            }
            else if (i < 40) {
                nws += String.valueOf((char) i);
            }
        }
        for (int i = 0; i <= 32; i++) {
            tr += String.valueOf((char) i);
        }
        WHITESPACE = ws;
        NON_WHITESPACE = nws;
        HARD_SPACE = hs;
        TRIMMABLE = tr;
        NON_TRIMMABLE = ntr;
    }

    private static final String[] ARRAY_LIST = {
        "foo",
        "bar",
        "baz"
    };

    private static final String[] EMPTY_ARRAY_LIST = {};

    private static final String[] NULL_ARRAY_LIST = {
        null
    };

    private static final Object[] NULL_TO_STRING_LIST = {
        new Object() {
            @Override
            public String toString() {
                return null;
            }
        }
    };

    private static final String[] MIXED_ARRAY_LIST = {
        null,
        "",
        "foo"
    };

    private static final Object[] MIXED_TYPE_LIST = {
        "foo",
        Long.valueOf(2L)
    };

    private static final long[] LONG_PRIM_LIST = {
        1,
        2
    };

    private static final int[] INT_PRIM_LIST = {
        1,
        2
    };

    private static final byte[] BYTE_PRIM_LIST = {
        1,
        2
    };

    private static final short[] SHORT_PRIM_LIST = {
        1,
        2
    };

    private static final char[] CHAR_PRIM_LIST = {
        '1',
        '2'
    };

    private static final float[] FLOAT_PRIM_LIST = {
        1,
        2
    };

    private static final double[] DOUBLE_PRIM_LIST = {
        1,
        2
    };

    private static final String SEPARATOR = ",";

    private static final char SEPARATOR_CHAR = ';';

    private static final String TEXT_LIST = "foo,bar,baz";

    private static final String TEXT_LIST_CHAR = "foo;bar;baz";

    private static final String TEXT_LIST_NOSEP = "foobarbaz";

    private static final String FOO_UNCAP = "foo";

    private static final String FOO_CAP = "Foo";

    private static final String SENTENCE_UNCAP = "foo bar baz";

    private static final String SENTENCE_CAP = "Foo Bar Baz";


    // -----------------------------------------------------------------------

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


    @Test
    public void testCapitalize() {
        assertNull(StringUtils.capitalize(null));

        assertEquals("capitalize(empty-string) failed", "",
                StringUtils.capitalize(""));
        assertEquals("capitalize(single-char-string) failed", "X",
                StringUtils.capitalize("x"));
        assertEquals("capitalize(String) failed", FOO_CAP,
                StringUtils.capitalize(FOO_CAP));
        assertEquals("capitalize(string) failed", FOO_CAP,
                StringUtils.capitalize(FOO_UNCAP));

        assertEquals("capitalize(String) is not using TitleCase", "\u01C8",
                StringUtils.capitalize("\u01C9"));

        // Javadoc examples
        assertNull(StringUtils.capitalize(null));
        assertEquals("", StringUtils.capitalize(""));
        assertEquals("Cat", StringUtils.capitalize("cat"));
        assertEquals("CAt", StringUtils.capitalize("cAt"));
        assertEquals("'cat'", StringUtils.capitalize("'cat'"));

        // MyTest
        assertEquals("I eat apple.", StringUtils.capitalize("i eat apple."));

    }
    
    @Test
    public void testUnCapitalize() {
        assertNull(StringUtils.uncapitalize(null));

        assertEquals("uncapitalize(String) failed",
                FOO_UNCAP, StringUtils.uncapitalize(FOO_CAP));
        assertEquals("uncapitalize(string) failed",
                FOO_UNCAP, StringUtils.uncapitalize(FOO_UNCAP));
        assertEquals("uncapitalize(empty-string) failed",
                "", StringUtils.uncapitalize(""));
        assertEquals("uncapitalize(single-char-string) failed",
                "x", StringUtils.uncapitalize("X"));

        // Examples from uncapitalize Javadoc
        assertEquals("cat", StringUtils.uncapitalize("cat"));
        assertEquals("cat", StringUtils.uncapitalize("Cat"));
        assertEquals("cAT", StringUtils.uncapitalize("CAT"));
    }
}
