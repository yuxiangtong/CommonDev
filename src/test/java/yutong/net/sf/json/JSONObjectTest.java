package yutong.net.sf.json;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import net.sf.json.JSONObject;


public class JSONObjectTest {

    @Test
    public void testToString() {
        JSONObject jsonObject = new JSONObject();

        /*
         * 方法：put
         * 1.当value=null时,做移除处理
         * 2.当key重复时,value值进行覆盖
         */
        jsonObject.put("key0", "");
        jsonObject.put("key2", null);
        jsonObject.put("key3", "value3");
        jsonObject.put("key0", "value0");

        String jsonString = jsonObject.toString();

        String expected = "{\"key0\":\"value0\",\"key3\":\"value3\"}";
        assertEquals(expected, jsonString);

    }
}
