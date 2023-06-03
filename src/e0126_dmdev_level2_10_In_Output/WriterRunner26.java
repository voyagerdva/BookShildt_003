package e0126_dmdev_level2_10_In_Output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterRunner26 {
    public static void main(String[] args) throws IOException {
//        File file = Path.of("resources", "writer.poem").toFile();
        Path path = Path.of("resources", "writer2.poem");
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {

        Files.write(path, List.of("Hello world!", "Java"));
//        try (BufferedWriter fileWriter = Files.newBufferedWriter(path)) {
//            fileWriter.append("Hello World@");
//            fileWriter.newLine();
//            fileWriter.append("Java");
//        }
    }
}
