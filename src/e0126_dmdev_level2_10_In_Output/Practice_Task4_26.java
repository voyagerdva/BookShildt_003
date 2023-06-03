package e0126_dmdev_level2_10_In_Output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Practice_Task4_26 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src","e0126_dmdev_level2_10_In_Output", "Practice_Task3_25.java");
        String stringValue = Files.readString(path);
        String result = stringValue.replace("public", "privatE");

        Path resultPath = Path.of("resources", "Task3.java");
        Files.writeString(resultPath, result);

    }

}
