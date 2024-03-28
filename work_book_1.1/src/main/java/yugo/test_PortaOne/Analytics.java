package yugo.test_PortaOne;

import java.util.List;

public class Analytics {

    private FileReader fileReader = new FileReader();
    private List<Integer> numbers = fileReader.getNumbers();

//    Агрегатные функции - это функции в реляционных базах данных, которые выполняют вычисления над набором значений в
//    столбце или ряде данных и возвращают единственное значение в качестве результата.
//    SUM: Вычисляет сумму значений в столбце.
//    COUNT: Подсчитывает количество строк или значений в столбце. Может использоваться для определения числа записей,
//    удовлетворяющих определенным условиям.
//    AVG (Average): Вычисляет среднее значение чисел в столбце.
//    MIN (Minimum): Находит минимальное значение в столбце.
//    MAX (Maximum): Находит максимальное значение в столбце.

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
