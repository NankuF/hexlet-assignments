package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> builds, int n) {
        var sortedBuilds = builds.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .collect(Collectors.toList());
        List<String> firstBuilds = sortedBuilds.stream().map(b -> b.toString()).limit(n).collect(Collectors.toList());
        return firstBuilds;
    }

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)));
        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }
}
// END
