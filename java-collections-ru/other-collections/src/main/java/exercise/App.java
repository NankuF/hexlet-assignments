package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static void main(String[] args) {
        Map<String, Object> map1 = new LinkedHashMap<>();
        Map<String, Object> map2 = new LinkedHashMap<>();
        map1.put("id", "1");
        map1.put("name", "Bob");
        map1.put("age", "22");
        map2.put("name", "Sam");
        map2.put("age", "22");
        map2.put("fun", "yes");
        var res = App.genDiff(map1, map2);
        System.out.println(res);
    }

    public static Map<String,Object> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
    // public static void genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object> result = new LinkedHashMap<>();
        Set<String> keys1 = map1.keySet();
        Set<String> keys2 = map2.keySet();
        for (String key : keys1) {
            System.out.println(map1.get(key));
            var map1Key = map1.get(key);
            var map2Key = map2.get(key);
            String r;
            if (map1Key.equals(map2Key)) {
                r = "unchanged";
            }
            else if (map2Key == null) {
                r = "deleted";
            } else {
                r = "changed";
            }

            result.put(key, r);
        }
        for (String key : keys2) {
            if (map1.get(key) == null) {
                var r = "added";
                result.put(key, r);
            }
        }

        return result;
    }
}
// END
