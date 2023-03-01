package ua.com.alevel;

public class Numbers {

    public int getNumbers(String count) {
        char[] charsNum = count.toCharArray();            // создаю из строки массив чаров
        int sum = 0;
        for (char c : charsNum) {                         // пробежался по массиву
            if (c <= 57 && c >= 48) {                     // если в введенной строке были цифры согласно диапазону (ascii),
                sum = sum + Character.getNumericValue(c); // получаю числовое значение, связанное с указанным индексом и суммирую значения данных индексов
            }
        }
        return (sum);
    }

}
