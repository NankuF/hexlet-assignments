# Знакомство со Spring Boot

## Ссылки

* [Начало работы со Spring Boot](https://spring.io/quickstart)

## src/main/java/exercise/Application.java

## Задачи

Реализуйте полный CRUD сущности `Post` по аналогии с тем, как мы делали это в уроке. Необходимо реализовать следующие маршруты:

* *GET /posts* - Список всех постов
* *GET /posts/{id}* – Просмотр конкретного поста
* *POST /posts* – Создание нового поста
* *PUT /posts/{id}* – Обновление поста
* *DELETE /posts/{id}* – Удаление поста

Бонусное задание: вывод списка постов реализуйте с пейджингом. Номер страницы и количество постов на странице передаются в качестве параметров строки запроса, например */posts?page=2&limit=10*. По умолчанию должна выводиться первая страница

### Подсказки

* В зависимости от вашей IDE, для работы автоматического рестарта могут потребоваться [дополнительные действия](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools.restart)

## Solution
Application.java
```java
    @GetMapping("/posts")
    public List<Post> index(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer limit) {

        return posts.stream().skip((page - 1) * limit).limit(limit).toList();
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> show(@PathVariable String id) {
        var post = posts.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
        return post;
    }

    @PutMapping("/posts/{id}")
    public Post update(@PathVariable String id, @RequestBody Post data) {
        var maybePost = posts.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
        if (maybePost.isPresent()) {
            var post = maybePost.get();
            post.setId(data.getId());
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
        }
        return data;
    }

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }

```