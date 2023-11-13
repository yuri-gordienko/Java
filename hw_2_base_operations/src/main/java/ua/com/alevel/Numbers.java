package ua.com.alevel;

public class Numbers {

    public int getNumbers(String string) {
        char[] charsNum = string.toCharArray();           // создаю из строки массив чаров
        int sum = 0;
        for (char c : charsNum) {                         // пробежался по массиву
            if (c <= 57 && c >= 48) {                     // если в введенной строке были цифры согласно диапазону (ascii),
                sum = sum + Character.getNumericValue(c); // получаю числовое значение, связанное с указанным индексом и суммирую значения данных индексов
            }
        }
        return (sum);


//        System.out.println(string);
//
//        int sum = 0;
//        char[] chars = string.toCharArray();
//
//        for (int i = 48; i <= 57; i++) {
////            System.out.println("index: " + i + "   symbol: " + (char) i);
//            for (int i1 = 0; i1 < chars.length; i1++) {
////                System.out.println(chars[i1]);
//                if ((char) i == chars[i1]) {
//                    sum += Character.getNumericValue(chars[i1]);
//                }
//            }
//        }
//        System.out.println(sum);
//        return sum;
    }
}
