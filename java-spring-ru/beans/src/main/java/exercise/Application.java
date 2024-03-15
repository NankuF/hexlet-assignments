package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;

// BEGIN

// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @Scope("prototype")
    public Daytime getDaytime() {
        var time = LocalDateTime.now();
        var sixAm = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), 6, 0);
        var twentyTwoPm = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), 22, 0);
        if (time.isAfter(sixAm) || time.isBefore(twentyTwoPm)) {
            return new Day();
        }
        return new Night();
    }
    // END
}
