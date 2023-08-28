package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static void main(String[] args) {
        scrabble("begsdhhtsexoult", "Hexlet");
    }

    public static boolean scrabble(String text, String word) {
        char[] chars = text.toCharArray();
        char[] words = word.toCharArray();
        List<Character> list = new ArrayList<>();
        List<Character> list_chars = new ArrayList<>();
        List<Character> list_words = new ArrayList<>();
        for (var c : chars) {
            list_chars.add(Character.toLowerCase(c));
        }
        for (var w : words) {
            list_words.add(Character.toLowerCase(w));
        }

        if (text.length() == 0 || word.length() == 0 || text.length() < word.length()) {
            return false;
        }
        for (var el : list_words) {
            if (list_chars.contains(el)) {
                list.add(el);
                list_chars.remove(el);
            }
        }

        var result = list.stream().map(Object::toString).collect(Collectors.joining("")).toLowerCase();
        System.out.println(result + " " + word);
        if (result.equalsIgnoreCase(word)) {
            return true;
        }
        return false;
    }
}
// END
