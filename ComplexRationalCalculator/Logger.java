package ComplexRationalCalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private FileWriter fileWriter;

    public Logger(String filePath) {
        try {
            fileWriter = new FileWriter(filePath, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        String logMessage = getCurrentTime() + " - " + message + "\n";

        try {
            fileWriter.write(logMessage);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentTime.format(formatter);
    }
}
