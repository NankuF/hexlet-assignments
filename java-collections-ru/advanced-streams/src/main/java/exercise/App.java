package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("src/test/resources/fixtures/s2.conf");
        String content = Files.readString(filePath);
        String result = App.getForwardedVariables(content);
    }

    public static String getForwardedVariables(String config) {
        String[] splitted = config.split("\n");
        List<String> envs = new ArrayList<>();
        for (String el : splitted) {
            if (el.startsWith("environment=")) {
                envs.add(el.replace("environment=", "").replace("\"", ""));
            }
        }
        List<String> result = new ArrayList<>();
        for (var row : envs) {
            String[] trash = row.split(",");
            for (var tr : trash) {
                if (tr.startsWith("X_FORWARDED_")) {
                    result.add(tr.replace("X_FORWARDED_", "").replace("\"", ""));
                }
            }
        }
            System.out.println(result.toString());
            return String.join(",", result);
        }
    }
// }
// END
