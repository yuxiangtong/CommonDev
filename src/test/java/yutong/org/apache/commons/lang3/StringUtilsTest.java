package yutong.org.apache.commons.lang3;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
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

        assertEquals("uncapitalize(String) failed", FOO_UNCAP,
                StringUtils.uncapitalize(FOO_CAP));
        assertEquals("uncapitalize(string) failed", FOO_UNCAP,
                StringUtils.uncapitalize(FOO_UNCAP));
        assertEquals("uncapitalize(empty-string) failed", "",
                StringUtils.uncapitalize(""));
        assertEquals("uncapitalize(single-char-string) failed", "x",
                StringUtils.uncapitalize("X"));

        // Examples from uncapitalize Javadoc
        assertEquals("cat", StringUtils.uncapitalize("cat"));
        assertEquals("cat", StringUtils.uncapitalize("Cat"));
        assertEquals("cAT", StringUtils.uncapitalize("CAT"));
    }


    @Test
    public void testReCapitalize() {
        // reflection type of tests: Sentences.
        assertEquals("uncapitalize(capitalize(String)) failed", SENTENCE_UNCAP,
                StringUtils
                        .uncapitalize(StringUtils.capitalize(SENTENCE_UNCAP)));
        assertEquals("capitalize(uncapitalize(String)) failed", SENTENCE_CAP,
                StringUtils.capitalize(StringUtils.uncapitalize(SENTENCE_CAP)));

        // reflection type of tests: One word.
        assertEquals("uncapitalize(capitalize(String)) failed", FOO_UNCAP,
                StringUtils.uncapitalize(StringUtils.capitalize(FOO_UNCAP)));
        assertEquals("capitalize(uncapitalize(String)) failed", FOO_CAP,
                StringUtils.capitalize(StringUtils.uncapitalize(FOO_CAP)));
    }


    @Test
    public void testSwapCase_String() {
        assertNull(StringUtils.swapCase(null));
        assertEquals("", StringUtils.swapCase(""));
        assertEquals("  ", StringUtils.swapCase("  "));

        assertEquals("i", WordUtils.swapCase("I"));
        assertEquals("I", WordUtils.swapCase("i"));
        assertEquals("I AM HERE 123", StringUtils.swapCase("i am here 123"));
        assertEquals("i aM hERE 123", StringUtils.swapCase("I Am Here 123"));
        assertEquals("I AM here 123", StringUtils.swapCase("i am HERE 123"));
        assertEquals("i am here 123", StringUtils.swapCase("I AM HERE 123"));

        final String test =
                "This String contains a TitleCase character: \u01C8";
        final String expect =
                "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9";
        assertEquals(expect, WordUtils.swapCase(test));
    }


    // -----------------------------------------------------------------------
    @Test
    public void testJoin_Objects() {
        assertEquals("abc", StringUtils.join("a", "b", "c"));
        assertEquals("a", StringUtils.join(null, "", "a"));
        assertNull(StringUtils.join((Object[]) null));
    }


    @Test
    public void testJoin_Objectarray() {
        // assertNull(StringUtils.join(null)); // generates warning
        assertNull(StringUtils.join((Object[]) null)); // equivalent explicit
                                                       // cast
        // test additional varargs calls
        assertEquals("", StringUtils.join(new Object[0])); // empty array
        assertEquals("", StringUtils.join((Object) null)); // => new
                                                           // Object[]{null}

        assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST));
        assertEquals("", StringUtils.join(NULL_ARRAY_LIST));
        assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST));
        assertEquals("abc", StringUtils.join(new String[] {
            "a",
            "b",
            "c"
        }));
        assertEquals("a", StringUtils.join(new String[] {
            null,
            "a",
            ""
        }));
        assertEquals("foo", StringUtils.join(MIXED_ARRAY_LIST));
        assertEquals("foo2", StringUtils.join(MIXED_TYPE_LIST));
    }
    
    @Test
    public void testJoin_ArrayCharSeparator() {
        assertNull(StringUtils.join((Object[]) null, ','));
        assertEquals(TEXT_LIST_CHAR, StringUtils.join(ARRAY_LIST, SEPARATOR_CHAR));
        assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR_CHAR));
        assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR_CHAR));
        assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR_CHAR));

        assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, '/', 0, MIXED_ARRAY_LIST.length - 1));
        assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 1));
        assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST, '/', 0, 1));
        assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, '/', 0, 2));
        assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, '/', 1, 2));
        assertEquals("", StringUtils.join(MIXED_TYPE_LIST, '/', 2, 1));
    }
    
    @Test
    public void testJoin_ArrayOfChars() {
        assertNull(StringUtils.join((char[]) null, ','));
        assertEquals("1;2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR));
        assertEquals("2", StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 2));
        assertNull(StringUtils.join((char[]) null, SEPARATOR_CHAR, 0, 1));
        assertEquals(StringUtils.EMPTY, StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 0, 0));
        assertEquals(StringUtils.EMPTY, StringUtils.join(CHAR_PRIM_LIST, SEPARATOR_CHAR, 1, 0));
    }
    
    @Test
    public void testJoin_ArrayOfBytes() {
        assertNull(StringUtils.join((byte[]) null, ','));
        assertEquals("1;2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR));
        assertEquals("2", StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 2));
        assertNull(StringUtils.join((byte[]) null, SEPARATOR_CHAR, 0, 1));
        assertEquals(StringUtils.EMPTY, StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 0, 0));
        assertEquals(StringUtils.EMPTY, StringUtils.join(BYTE_PRIM_LIST, SEPARATOR_CHAR, 1, 0));
    }
    
    @Test
    public void testJoin_ArrayOfInts() {
        assertNull(StringUtils.join((int[]) null, ','));
        assertEquals("1;2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR));
        assertEquals("2", StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 2));
        assertNull(StringUtils.join((int[]) null, SEPARATOR_CHAR, 0, 1));
        assertEquals(StringUtils.EMPTY, StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 0, 0));
        assertEquals(StringUtils.EMPTY, StringUtils.join(INT_PRIM_LIST, SEPARATOR_CHAR, 1, 0));
    }

    @Test
    public void testJoin_ArrayOfLongs() {
        assertNull(StringUtils.join((long[]) null, ','));
        assertEquals("1;2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR));
        assertEquals("2", StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 2));
        assertNull(StringUtils.join((long[]) null, SEPARATOR_CHAR, 0, 1));
        assertEquals(StringUtils.EMPTY, StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 0, 0));
        assertEquals(StringUtils.EMPTY, StringUtils.join(LONG_PRIM_LIST, SEPARATOR_CHAR, 1, 0));
    }
    
    @Test
    public void testJoin_ArrayOfFloats() {
        assertNull(StringUtils.join((float[]) null, ','));
        assertEquals("1.0;2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR));
        assertEquals("2.0", StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 2));
        assertNull(StringUtils.join((float[]) null, SEPARATOR_CHAR, 0, 1));
        assertEquals(StringUtils.EMPTY, StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 0, 0));
        assertEquals(StringUtils.EMPTY, StringUtils.join(FLOAT_PRIM_LIST, SEPARATOR_CHAR, 1, 0));
    }
    
    @Test
    public void testJoin_ArrayOfDoubles() {
        assertNull(StringUtils.join((double[]) null, ','));
        assertEquals("1.0;2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR));
        assertEquals("2.0", StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 2));
        assertNull(StringUtils.join((double[]) null, SEPARATOR_CHAR, 0, 1));
        assertEquals(StringUtils.EMPTY, StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 0, 0));
        assertEquals(StringUtils.EMPTY, StringUtils.join(DOUBLE_PRIM_LIST, SEPARATOR_CHAR, 1, 0));
    }
    
    @Test
    public void testJoin_ArrayOfShorts() {
        assertNull(StringUtils.join((short[]) null, ','));
        assertEquals("1;2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR));
        assertEquals("2", StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 2));
        assertNull(StringUtils.join((short[]) null, SEPARATOR_CHAR, 0, 1));
        assertEquals(StringUtils.EMPTY, StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 0, 0));
        assertEquals(StringUtils.EMPTY, StringUtils.join(SHORT_PRIM_LIST, SEPARATOR_CHAR, 1, 0));
    }

    @Test
    public void testJoin_ArrayString() {
        assertNull(StringUtils.join((Object[]) null, null));
        assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null));
        assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, ""));

        assertEquals("", StringUtils.join(NULL_ARRAY_LIST, null));

        assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null));
        assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, ""));
        assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, SEPARATOR));

        assertEquals(TEXT_LIST, StringUtils.join(ARRAY_LIST, SEPARATOR));
        assertEquals(",,foo", StringUtils.join(MIXED_ARRAY_LIST, SEPARATOR));
        assertEquals("foo,2", StringUtils.join(MIXED_TYPE_LIST, SEPARATOR));

        assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, "/", 0, MIXED_ARRAY_LIST.length - 1));
        assertEquals("", StringUtils.join(MIXED_ARRAY_LIST, "", 0, MIXED_ARRAY_LIST.length - 1));
        assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 1));
        assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2));
        assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2));
        assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 2, 1));
    }
    
    @Test
    public void testJoin_IteratorChar() {
        assertNull(StringUtils.join((Iterator<?>) null, ','));
        assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR_CHAR));
        assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), SEPARATOR_CHAR));
        assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR_CHAR));
        assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), 'x'));
    }
    
    @Test
    public void testJoin_IteratorString() {
        assertNull(StringUtils.join((Iterator<?>) null, null));
        assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), null));
        assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), ""));
        assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), "x"));
        assertEquals("foo", StringUtils.join(Collections.singleton("foo").iterator(), null));

        assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST).iterator(), null));

        assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), null));
        assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), ""));
        assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST).iterator(), SEPARATOR));

        assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST).iterator(), SEPARATOR));

        assertNull(StringUtils.join(Arrays.asList(NULL_TO_STRING_LIST).iterator(), SEPARATOR));
    }

    @Test
    public void testJoin_IterableChar() {
        assertNull(StringUtils.join((Iterable<?>) null, ','));
        assertEquals(TEXT_LIST_CHAR, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR_CHAR));
        assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), SEPARATOR_CHAR));
        assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR_CHAR));
        assertEquals("foo", StringUtils.join(Collections.singleton("foo"), 'x'));
    }

    @Test
    public void testJoin_IterableString() {
        assertNull(StringUtils.join((Iterable<?>) null, null));
        assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), null));
        assertEquals(TEXT_LIST_NOSEP, StringUtils.join(Arrays.asList(ARRAY_LIST), ""));
        assertEquals("foo", StringUtils.join(Collections.singleton("foo"), "x"));
        assertEquals("foo", StringUtils.join(Collections.singleton("foo"), null));

        assertEquals("", StringUtils.join(Arrays.asList(NULL_ARRAY_LIST), null));

        assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), null));
        assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), ""));
        assertEquals("", StringUtils.join(Arrays.asList(EMPTY_ARRAY_LIST), SEPARATOR));

        assertEquals(TEXT_LIST, StringUtils.join(Arrays.asList(ARRAY_LIST), SEPARATOR));
    }
    
    @Test
    public void testJoinWith() {
//        assertEquals("", StringUtils.joinWith(",", new Object[0]));        // empty array
//        assertEquals("", StringUtils.joinWith(",", (Object[]) NULL_ARRAY_LIST));
//        assertEquals("null", StringUtils.joinWith(",", NULL_TO_STRING_LIST));   //toString method prints 'null'
//
//        assertEquals("a,b,c", StringUtils.joinWith(",", new Object[]{"a", "b", "c"}));
//        assertEquals(",a,", StringUtils.joinWith(",", new Object[]{null, "a", ""}));
//
//        assertEquals("ab", StringUtils.joinWith(null, "a", "b"));
    }

    
    
//    public static void main(String[] args) {
//        System.out.println("123".substring(1, 3));
//    }
}
