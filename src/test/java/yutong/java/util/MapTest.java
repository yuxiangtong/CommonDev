package yutong.java.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class MapTest {

    /**
     * 测试顺序
     * <table border="1">
     * <tr>
     * <td>HashMap</td>
     * <td>无序</td>
     * </tr>
     * <tr>
     * <td>LinkedHashMap</td>
     * <td>有序</td>
     * </tr>
     * </table>
     * 
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; i < 100; i++) {
            hashMap.put("" + i, "" + i);
        }

        Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < 100; i++) {
            linkedHashMap.put("" + i, "" + i);
        }

        System.out.println("hashMap[99]:" + get99(hashMap));
        System.out.println("linkedHashMap[99]:" + get99(linkedHashMap));
    }


    private static String get99(Map<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        int i = 0;
        String str99 = "";
        while (iterator.hasNext()) {
            str99 = iterator.next();
            i++;
            if (i == 99) {
                break;
            }
        }
        return str99;
    }

}
