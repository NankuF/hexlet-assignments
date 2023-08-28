package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static void main(String[] args){
        scrabble("rkqodlw", "world");
    }
    public static boolean scrabble(String text, String word) {
        char[] chars = text.toCharArray();
        char[] words = word.toCharArray();
        List<Character> list = new ArrayList<>();
        if (text.length() < word.length()) {
            return false;
        }
        for (var w: words){
            for (var c : chars) {
                if (c == w) {
                    list.add(w);
                }
            }
        }

        // var new_world = String.join(", ", list);
        var new_world = list.stream().map(Object::toString).collect(Collectors.joining(""));
        System.out.println(new_world);
        if (new_world.equals(word)) {
            System.out.println(new_world + " " + word);
            return true;
        }
        return false;
    }
}
//END
