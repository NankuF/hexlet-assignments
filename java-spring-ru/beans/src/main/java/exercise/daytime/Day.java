package exercise.daytime;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;


public class Day implements Daytime {
    private String name = "day";

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
