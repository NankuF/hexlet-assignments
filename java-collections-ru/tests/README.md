# Тестирование

## src/test/java/exercise/AppTest.java

## Задачи

Напишите тесты для публичного статического метода `take()`. Метод принимает в качестве аргументов список `List` целых чисел и число элементов, а возвращает новый список, который содержит первые `n` элементов исходного списка.

```java
List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
System.out.println(App.take(numbers1, 2)); // => [1, 2]

List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
System.out.println(App.take(numbers2, 8)); // => [7, 3, 10]
```

## Solution
```java
        List<Integer> list1 = new ArrayList<>();
        List<Integer> expected1 = new ArrayList<>();
        List<Integer> result1 = App.take(list1, 3);
        assertThat(result1).isEqualTo(expected1);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> result2 = App.take(list2, 10);
        assertThat(result2).isEqualTo(expected2);

        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> expected3 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> result3 = App.take(list3, 2);
        assertThat(result3).isEqualTo(expected3);
```