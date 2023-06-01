package e0126_dmdev_level2_10_In_Output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WriterRunner25 {
    public static void main(String[] args) throws IOException {
        File file = Path.of("resources", "writer.poem").toFile();
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {
            fileWriter.append("Hello World@");
            fileWriter.newLine();
            fileWriter.append("Java");

        }
    }
}
