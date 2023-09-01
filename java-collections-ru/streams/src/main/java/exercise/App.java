package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static void main(String[] args) {
        String[] emails = {
                "info@gmail.com",
                "info@yandex.ru",
                "mk@host.com",
                "support@hexlet.io",
                "info@hotmail.com",
                "support.yandex.ru@host.com"
        };

        List<String> emailsList = Arrays.asList(emails);
        App.getCountOfFreeEmails(emailsList); // 3
    }

    public static long getCountOfFreeEmails(List<String> emails) {
        long amount = emails.stream()
                .filter(name -> name.contains("@gmail.com") || name.contains("@yandex.ru")
                        || name.contains("@hotmail.com"))
                .count();
        System.out.println("Count free emails hostings: " + amount);

        return amount;
    }
}
// END
