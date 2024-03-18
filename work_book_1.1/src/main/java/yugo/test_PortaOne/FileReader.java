package yugo.test_PortaOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

import static yugo.test_PortaOne.Enums.DATA_FILE;

public class FileReader {

    public List<Integer> numbers = new ArrayList<>();
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void initFile() {
        try (InputStream inputStream = getClass().getResourceAsStream(DATA_FILE.getDataFile())) {
            if (inputStream == null) {
                System.out.println("Файл не знайдено.");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Помилка перетворення числа: " + e.getMessage());
                }
            }
        } catch(IOException e) {
            System.out.println("Виникла помилка при читанні файлу: " + e.getMessage());
        }
        System.out.println("numbers = " + numbers);

//        -------------------------------------------------------------------------------------------
//        try (InputStream inputStream = FileReader.class.getResourceAsStream("/data_test.txt")) {
//            if (inputStream == null) {
//                System.out.println("Файл не знайдено.");
//                return;
//            }
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                System.out.println("element = " + line);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }





    }
}

