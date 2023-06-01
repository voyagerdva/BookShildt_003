package e0126_dmdev_level2_10_In_Output;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Practice_Task1_25 {
    public static final String VOWELS = "аоуыэяёюие";

    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "test.txt");

        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                char firstSymbol = word.charAt(0);
                if (VOWELS.indexOf(firstSymbol) != -1) {
                    System.out.println(word);
                }
            }
        }
    }
}
