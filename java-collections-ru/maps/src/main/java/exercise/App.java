package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

// BEGIN
class App {
    public static void main(String[] args) {
        var s = getWordCount("java is the best programming language java");
        toString(s);
    }

    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> hm = new HashMap<>();
        var arr_text = text.split(" ");
        System.out.println(Arrays.toString(arr_text));
        for (String key : arr_text) {
            if (!hm.containsKey(key)) {
                hm.put(key, 1);
            } else {
                hm.put(key, hm.get(key) + 1);
            }
        }
        System.out.println(hm);
        return hm;
    }

    public static String toString(Map<String, Integer> hm) {
        if (hm.isEmpty()) {
            return "";
        }
        // Set<String> keys = hm.keySet();
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        str.append("{\n");
        for (var key : hm.keySet()) {
            str.append("  ");
            str.append(key);
            str.append(": ");
            str.append(hm.get(key));
            str.append("\n");
        }
        str.append("}");
        System.out.println(str.toString());
        return str.toString();
    }
}
//END
