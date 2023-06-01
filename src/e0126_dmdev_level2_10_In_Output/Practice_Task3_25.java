package e0126_dmdev_level2_10_In_Output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Practice_Task3_25 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "test.txt");
        Files.readAllLines(path).stream()
                .map(Practice_Task3_25::findMaxDigitsCount)
                .forEach(System.out::println);

    }

    public static Integer findMaxDigitsCount(String line) {
        int result = 0;
        int counter = 0;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                counter++;
            } else {
                if (result < counter) {
                    result = counter;
                }
            }
        }

        return result;
    }

}
