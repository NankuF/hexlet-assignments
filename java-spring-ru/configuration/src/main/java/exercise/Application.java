package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import exercise.model.User;
import exercise.component.UserProperties;

@SpringBootApplication
@RestController
public class Application {

    // Все пользователи
    private List<User> users = Data.getUsers();

    // BEGIN
    @Autowired
    private UserProperties userProps;
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

    @GetMapping("/admins")
    public List<String> getAdmins() {
        List<String> adminsMail = userProps.getAdmins();
        List<String> admins = users.stream()
                .filter(u -> adminsMail.contains(u.getEmail()))
                .map(u -> u.getName())
                .sorted()
                .toList();
        return admins;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
