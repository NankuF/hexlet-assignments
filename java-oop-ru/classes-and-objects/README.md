# Классы и объекты

## main/java/exercise/Point.java

Точка — графический примитив на координатной плоскости, который описывается двумя координатами по оси X и по оси Y.

## Задачи

* Создайте класс `Point`. Внутри класса реализуйте конструктор, который принимает два целых числа — координаты точки по осям `x` и `y`. В классе определите следующие методы:

  * `getX()` — возвращает координату точки по оси `x`.
  * `getY()` — возвращает координату точки по оси `y`.

  ```java
  Point point = new Point(4, 3);
  int x = point.getX(); // 4
  int y = point.getY(); // 3
  ```

## main/java/exercise/Segment.java

Отрезок - еще один графический примитив, который определяется двумя точками — началом и концом отрезка.

## Задачи

* Создайте класс `Segment`. Внутри класса реализуйте конструктор, который принимает две точки — начало и конец отрезка. Точка — это объект класса `Point`. В классе определите следующие методы:

  * `getBeginPoint()` — возвращает начальную точку отрезка.
  * `getEndPoint()` — возвращает конечную точку отрезка.
  * `getMidPoint()` — возвращает новую точку — середину отрезка.

  ```java
  Point point1 = new Point(4, 3);
  Point point2 = new Point(6, 1);
  Segment segment = new Segment(point1, point2);
  Point midPoint = segment.getMidPoint();
  midPoint.getX(); // 5
  midPoint.getY(); // 2
  ```

## Solution

Point.java

```java
class Point {
    private int x;
    private int y;

    Point(int coordinateX, int coordinateY) {
        this.x = coordinateX;
        this.y = coordinateY;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

```

Segment.java

```java
class Segment {
    private Point beginPoint;
    private Point endPoint;

    Segment(Point point1, Point point2) {
        this.beginPoint = point1;
        this.endPoint = point2;
    }

    public Point getBeginPoint() {
        return this.beginPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    public Point getMidPoint() {
        int newX = (beginPoint.getX() + endPoint.getX()) / 2;
        int newY = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(newX, newY);
    }
}
```
