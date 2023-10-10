# Интерфейсы

## main/java/exercise/Home.java

## Задачи

* Реализуйте интерфейс `Home` для работы с недвижимостью. Этот интерфейс содержит два метода:

  * `getArea()` — предназначен для получения общей площади объекта недвижимости.
  * `compareTo()` — Служит для сравнения двух объектов недвижимости по их площади.

## main/java/exercise/Flat.java

* Реализуйте класс `Flat()`, который представляет объект недвижимости — квартиру. Класс должен реализовывать интерфейс `Home`. Конструктор класса принимает на вход три параметра:

  * `area` — жилая площадь квартиры, число типа `double`
  * `balconyArea` — площадь балкона, число типа `double`
  * `floor` — этаж, на котором расположена квартира

   Общая площадь квартиры складывается из жилой площади и площади балкона.

   Метод `toString()` должен возвращать представление квартиры в виде строки формата "Квартира площадью 56 метров на 5 этаже".

   Метод `compareTo(Home another)` в качестве аргумента принимает другой объект недвижимости и сравнивает их по площади. Метод должен вернуть 1, если площадь текущего объекта больше площади переданного; -1, если площадь текущего объекта меньше площади переданного и 0, если площади равны.

  ```java
  Home flat = new Flat(54.5, 4, 3);
  double area = flat.getArea(); // 58.5
  flat.toString(); // "Квартира площадью 58.5 метров на 3 этаже"
  ```

## main/java/exercise/Cottage.java

* Реализуйте класс `Cottage()`, который представляет еще один объект недвижимости — коттедж. Класс должен реализовывать интерфейс `Home`. Конструктор класса принимает на вход два параметра:

  * `area` — Общая площадь коттеджа, число типа `double`
  * `floorCount` — количество этажей

   Метод `toString()` должен возвращать представление коттеджа в виде строки формата "2 этажный коттедж площадью 120.5 метров".

   Метод `compareTo(Home another)` работает аналогично методу в классе `Flat`

  ```java
  Home cottage = new Cottage(135, 2);
  double area = cottage.getArea(); // 135
  cottage.toString(); // "2 этажный коттедж площадью 135 метров"
  ```

## main/java/exercise/App.java

* Создайте класс `App` с публичным статическим методом `buildApartmentsList()`. Метод принимает в качестве первого аргумента список `List` объектов недвижимости, реализующих интерфейс `Home`. Метод сортирует объекты по площади по возрастанию, берет первые n элементов и возвращает  строковые представления этих объектов в виде списка `List`. Количество `n` элементов передаётся в метод `buildApartmentsList()` вторым параметром.

```java
List<Home> apartments = new ArrayList<>(List.of(
    new Flat(41, 3, 10),
    new Cottage(125.5, 2),
    new Flat(80, 10, 2),
    new Cottage(150, 3)
));

List<String> result = App.buildApartmentsList(apartments, 3);
System.out.println(result); // =>
// [
//     Квартира площадью 44.0 метров на 10 этаже,
//     Квартира площадью 90.0 метров на 2 этаже,
//     2 этажный коттедж площадью 125.5 метров
// ]
```

## Самостоятельная работа

* В файле *ReversedSequence.java* реализуйте класс `ReversedSequence`, который реализует стандартный интерфейс java.lang `CharSequence`. Конструктор класса принимает на вход строку. Ваша реализация должна представлять последовательность в перевернутом виде.

```java
CharSequence text = new ReversedSequence("abcdef");
text.toString(); // "fedcba"
text.charAt(1); // 'e'
text.length(); // 6
text.subSequence(1, 4).toString(); // "edc"
```

* Напишите тесты для проверки методов класса `ReversedSequence`.

## Solution

Home.java

```java
interface Home {
    int compareTo(Home home);

    double getArea();
}
```

Cottage.java

```java
class Cottage implements Home {
    private double area;
    private int floorCount;

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return this.area;
    }

    public String toString() {
        return String.format("%d этажный коттедж площадью %s метров", floorCount, getArea());
    }

    public int compareTo(Home another) {
        if (area == another.getArea()) {
            return 0;
        }

        if (area > another.getArea()) {
            return 1;
        }

        return -1;
    }
}
```

Flat.java

```java
class Flat implements Home {
    private double area;
    private int floor;
    private double balconyArea;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return this.area + balconyArea;
    }

    public String toString() {
        return String.format("Квартира площадью %s метров на %d этаже", getArea(), floor);
    }

    public int compareTo(Home another) {
        if (this.getArea() == another.getArea()) {
            return 0;
        }

        if (this.getArea() > another.getArea()) {
            return 1;
        }

        return -1;
    }
}
```

App.java

```java
class App {

    // new
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        return apartments.stream()
            .sorted(Home::compareTo)
            .limit(count)
            .map(Home::toString)
            .toList();
    }
    // old
    public static List<String> buildApartmentsList2(List<Home> apartments, int count) {
        int normalizedCount = Math.min(count, apartments.size());
        apartments.sort(Home::compareTo);
        List<Home> sublist = apartments.subList(0, normalizedCount);
        return sublist.stream()
            .map(appartment -> appartment.toString())
            .collect(Collectors.toList());
    }
}
```

AppTest.java

```java
    @Test
    void testReversedSequence() {
        CharSequence text = new ReversedSequence("abcdef");
        assertThat(text.toString()).isEqualTo("fedcba");

        assertThat(text.length()).isEqualTo(6);

        assertThat(text.charAt(1)).isEqualTo('e');
        assertThat(text.charAt(4)).isEqualTo('b');

        assertThat(text.subSequence(1, 4).toString()).isEqualTo("edc");
    }
```

ReversedSequence.java

```java
class ReversedSequence implements CharSequence {
    private String text;

    ReversedSequence(String text) {
        StringBuilder s  = new StringBuilder(text);
        this.text = s.reverse().toString();
    }

    public int length() {
        return text.length();
    }

    public char charAt(int index) {

        return text.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return text.subSequence(start, end);
    }

    public String toString() {
        return text;
    }

}
```
