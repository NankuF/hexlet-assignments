package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static void main(String[] args) {
        var s = getWordCount("");
        toString(s);
    }

    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> hm = new HashMap<>();
        if (text.length() == 0){return hm;}
        var arr_text = text.split(" ");
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
        if (hm.isEmpty() || hm.containsKey("")) {
            return "{}";
        }
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
