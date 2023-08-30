package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

// BEGIN
class App {
    public static void main(String[] args) {
        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));
        List<Map<String, String>> books = new ArrayList<>();
        books.add(where);
        findWhere(books, where);
    }

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> searchBook) {
        // List<Map<String, String>> books = new ArrayList<>();

        // Map<String, String> book1 = new HashMap<>(
        // Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611")
        // );
        // Map<String, String> book2 = new HashMap<>(
        //     Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111")
        // );
        // Map<String, String> book3 = new HashMap<>(
        //     Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611")
        // );
        // Map<String, String> book4 = new HashMap<>(
        //     Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222")
        // );
        // Map<String, String> book5 = new HashMap<>(
        //     Map.of("title", "Still foooing", "author", "FooBar", "year", "3333")
        // );

        // books.add(book1);
        // books.add(book2);
        // books.add(book3);
        // books.add(book4);
        // books.add(book5);
        List<Map<String, String>> list = new ArrayList<>();
        if (books.isEmpty()) {
            return list;}
        for (var book : books) {
            if (book.entrySet().containsAll(searchBook.entrySet())) {
                list.add(book);
            }
            // if (searchBook.get("author") == book.get("author")
            // & searchBook.get("title") == book.get("title")
            // & searchBook.get("year") == book.get("year")
            // ) {
            //         list.add(book);
            //     }
            // else if (searchBook.get("author") == book.get("author") & searchBook.get("year") == book.get("year")){
            //     list.add(book);
            // }
        }

        System.out.println(list);
        return list;
    }
}
//END
