package e0126_dmdev_level2_10_In_Output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Practice_Task5_25 {
    public static void main(String[] args) {
        Path path = Path.of("src", "e0126_dmdev_level2_10_In_Output", "Practice_Task4_25.java");
        Path result = Path.of("resources", "Task4.java");

        try (Stream<String> lines = Files.lines(path);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(result, APPEND, CREATE)) {

            lines
                    .map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    .forEach(line -> {
                        try {
                            bufferedWriter.write(line.toString());
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
