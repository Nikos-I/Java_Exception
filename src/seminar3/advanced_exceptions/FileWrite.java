package seminar3.advanced_exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public void writeData(String data, String path) {
        try(FileWriter fw = new FileWriter(path, true)) {
            fw.append(data);
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}