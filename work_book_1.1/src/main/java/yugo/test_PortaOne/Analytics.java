package yugo.test_PortaOne;

import java.util.List;

public class Analytics {

    private FileReader fileReader = new FileReader();
    private List<Integer> numbers = fileReader.getNumbers();

//    1. максимальне число в файлі
    public Integer getMaxNumber(List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            Integer max = numbers.get(0);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) != null && numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
            System.out.println("Максимальне число: " + max);
            return max;
        } else {
            System.out.println("Масив порожній.");
            return null;
        }
    }

//    2. мінімальне число в файлі
    public Integer getMinNumber(List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            Integer min = numbers.get(0);

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) != null && numbers.get(i) < min) {
                    min = numbers.get(i);
                }
            }
            System.out.println("Мінімальне число: " + min);
            return min;
        } else {
            System.out.println("Масив порожній.");
            return null;
        }
    }



}
