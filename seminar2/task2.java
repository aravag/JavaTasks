package seminar2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class task2 {
    public static void main(String[] args) {
        String fileName = "file.txt";
        String text = "TEXT" + " "; 

        File file = new File(fileName);

        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }

            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < 100; i++) {
                writer.write(text);
            }
            writer.close();
            System.out.println("Текст записан в файл");

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

}