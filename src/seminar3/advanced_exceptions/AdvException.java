package seminar3.advanced_exceptions;

import java.util.HashMap;
// Происходит запуск приложения
public class AdvException {
    public static void main(String[] args) {
        DataParsing parsData = new DataParsing();
        String newFileName = null;
        FileWrite dataFile = new FileWrite();

        HashMap<String, Object> data = parsData.parsingInputData(); // Словарь данных
        while (data.size() != 6) {
            try {
                throw new DataException();
            } catch (DataException e) {
                data = parsData.parsingInputData();
            }
        } // Цикл для ввода данных, пока пользователь не введет корректные данные

        newFileName = data.get("lastName") + ".dat"; // Указывается файл для записи данных пользователя
        StringBuilder sb = new StringBuilder();
        for (String str : data.keySet()) {
            sb.append(data.get(str));
            sb.append(" ");
        }


        String filePath = newFileName;
        dataFile.writeData(data.toString(), filePath); // Запись в файл

    }
}
