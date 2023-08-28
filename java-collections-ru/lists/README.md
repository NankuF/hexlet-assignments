# Коллекции

## main/java/exercise/App.java

## Задачи

Скрэббл (от англ. Scrabble — «рыться в поисках чего-либо») — настольная игра, в которой игроки соревнуются в образовании слов из плиток с буквами.

Реализуйте публичный статический метод `scrabble()`, который принимает на вход два параметра: набор символов для составления слова в нижнем регистре (в виде строки) и слово. Метод проверяет, можно ли из переданного набора составить это слово. В результате вызова функция возвращает `true` или `false`.

При проверке учитывается количество символов, нужных для составления слова и не учитывается их регистр (заглавные и строчные символы считаются одинаковыми).

```java
App.scrabble("rkqodlw", "world"); // true
App.scrabble("ajv", "java"); // false
App.scrabble("avjafff", "JaVa"); // true
App.scrabble("", "hexlet"); // false
```

Solution
```java
class App {
    public static boolean scrabble(String symbols, String word) {

        int length = word.length();
        String[] letters = symbols.split("");
        List coll = new ArrayList(Arrays.asList(letters));

        for (int i = 0; i < length; i++) {
            String current = word.substring(i, i + 1).toLowerCase();

            if (!coll.contains(current)) {
                return false;
            }

            coll.remove(current);
        }

        return true;
    }
}
```
