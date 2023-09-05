package exercise;

import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static void main(String[] args) {
        List<Map<String, String>> users = List.of(
                Map.of("name", "Anna Sidorova", "birthday", "1996-09-09", "gender", "female"),
                Map.of("name", "Vanessa Vulf", "birthday", "1985-11-16", "gender", "male"),
                Map.of("name", "Alice Lucas", "birthday", "1986-01-01", "gender", "male"),
                Map.of("name", "Elsa Oscar", "birthday", "1970-03-10", "gender", "female"));
        takeOldestMans(users);
    }

    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted((user1,user2) -> LocalDate.parse(user1.get("birthday")).compareTo(LocalDate.parse(user2.get("birthday"))))
                .map(user -> user.get("name"))
        .peek(System.out::println)
        .collect(Collectors.toList());


    }
}
// END
