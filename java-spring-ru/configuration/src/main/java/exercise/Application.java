package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.comparator.Comparators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.util.PropertySource.Comparator;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import exercise.model.User;
import exercise.component.UserProperties;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class Application {

    // Все пользователи
    private List<User> users = Data.getUsers();

    // BEGIN
    @Autowired
    private UserProperties user_prop;

    @GetMapping("/admins")
    public List<String> getAdmins() {
        List<String> userNames = new ArrayList<>();
        var maybeUser = users.stream()
            .filter(u -> user_prop.getAdmins().contains(u.getEmail()))
            .map(u->u.getName())
            .toList();
            userNames.addAll(maybeUser);
        Collections.sort(userNames);
        return userNames;
    }


    // END

    @GetMapping("/users")
    public List<User> index() {
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Long id) {
        var user = users.stream()
            .filter(u -> u.getId() == id)
            .findFirst();
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
