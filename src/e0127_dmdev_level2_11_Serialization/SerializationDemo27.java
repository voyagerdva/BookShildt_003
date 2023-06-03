package e0127_dmdev_level2_11_Serialization;

import java.io.*;
import java.nio.file.Path;

public class SerializationDemo27 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Path.of("resources", "student.out");

        writeObject(path);

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Object object = objectInputStream.readObject();
            System.out.println(object );
        }
    }

    private static void writeObject(Path path) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            Person27 sergey = new Person27(26, "Sergey");
            objectOutputStream.writeObject(sergey);
        }
    }
}
