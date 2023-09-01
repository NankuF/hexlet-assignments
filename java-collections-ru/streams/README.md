# Стримы

## Ссылки

* [Класс Collectors](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Collectors.html#counting())

## src/main/java/exercise/App.java

## Задачи

Создайте класс `App` c публичным статическим методом `getCountOfFreeEmails()`. Метод принимает в качестве аргумента список `List` емейлов, а возвращает общее количество емейлов, расположенных на бесплатных доменах. Бесплатные домены: gmail.com, yandex.ru и hotmail.com.

```java
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
```

## Подсказки

* Для подсчета количества элементов в стриме можно воспользоваться методом `count()`


## Solution
```java
class App {

    private static final List<String> FREE_DOMAINS = Arrays.asList(
        "gmail.com", "yandex.ru", "hotmail.com"
    );

    public static long getCountOfFreeEmails(List<String> emails) {
        return emails
            .stream()
            .map(email -> email.split("@")[1])
            .filter(email -> FREE_DOMAINS.contains(email))
            .count();
    }
}
```