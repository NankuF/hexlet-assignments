package exercise.daytime;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public String hello() {
        return String.format("It is %s now! Welcome to Spring!", getName());
    }

    @Override
    public String toString() {
        return hello();
    }
    // END
}
