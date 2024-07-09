package yugo.test_PortaOne;

import java.util.Arrays;

public class MyVariant {

    public static void main(String[] args) {

        int[] numbers = new int[]{minNumber(new int[]{-1, 23, -111, 48, 100, 212, 0, -10, 88, 44})};
        int minNumber = minNumber(numbers);
        System.out.println("minNumber = " + minNumber);
        int[] numbers2 = new int[]{maxNumber(new int[]{-1, 23, -111, 48, 100, 212, 0, -10, 88, 44})};
        double[] numbers3 = new double[]{medianNumberOdd(new int[]{-1, 23, -111, 48, 100, 0, -10, 88, 44})};
        double[] numbers4 = new double[]{medianNumberEven(new int[]{-1, 23, -111, 48, 100, 212, 0, -10, 88, 44})};
        double[] numbers5 = new double[]{averageNumber(new int[]{-1, 23, -111, 48, 100, 212, 0, -10, 88, 44})};
        int[] numbers6 = findLongestIncreasingSequence(new int[]{-1, 23, -111, 48, 100, 212, 0, 1, 2, 3, 4, 5, 6, -10, 88, 44});
        int[] numbers7 = findLongestDecreasingSequence(new int[]{-1, 23, -111, 48, 100, 212, 0, -10, 88, 44});
    }


//    min number
    private static int minNumber(int[] numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int minNumber = numbers[0];

        for (int number : numbers) {
            if (minNumber > number) {
                minNumber = number;
            }
        }
        System.out.println("minNumber = " + minNumber);
        return minNumber;
    }


//    min number
    private static int maxNumber(int[] numbers2) {

        if (numbers2 == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (numbers2.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int maxNumber = numbers2[0];

        for (int number : numbers2) {
            if (maxNumber < number) {
                maxNumber = number;
            }
        }
        System.out.println("maxNumber = " + maxNumber);
        return maxNumber;
    }


//    median number Odd
    private static double medianNumberOdd(int[] numbers3) {

        if (numbers3 == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (numbers3.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        // Сортуємо масив
        Arrays.sort(numbers3);
        System.out.println("sortedArray = " + Arrays.toString(numbers3));

        double medianNumber;
        if (numbers3.length % 2 != 0) {
            medianNumber = numbers3[numbers3.length / 2];

        } else {
            medianNumber = (numbers3[numbers3.length / 2 - 1] + numbers3[numbers3.length / 2]) / 2.0;
        }

        System.out.println("OddMedianNumber = " + medianNumber);
        return medianNumber;
    }

//    median number Even
    private static double medianNumberEven(int[] numbers4) {

        if (numbers4 == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (numbers4.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

//   Сортуємо масив
        Arrays.sort(numbers4);
        System.out.println("sortedArray = " + Arrays.toString(numbers4));

        double medianNumber;
        if (numbers4.length % 2 != 0) {
            medianNumber = numbers4[numbers4.length / 2];

        } else {
            medianNumber = (numbers4[numbers4.length / 2 - 1] + numbers4[numbers4.length / 2]) / 2.0;
        }

        System.out.println("EvenMedianNumber = " + medianNumber);
        return medianNumber;
    }

//    average number
    private static double averageNumber(int[] numbers5) {
        if (numbers5 == null || numbers5.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        double averageNumber = 0;
        for (int number : numbers5) {
            averageNumber += (double) number / numbers5.length;
        }
        System.out.println("averageNumber = " + averageNumber);
        return averageNumber;
    }

// Метод для пошуку найбільшої зростаючої послідовності чисел
    public static int[] findLongestIncreasingSequence(int[] numbers6) {
        if (numbers6 == null || numbers6.length == 0) {
            throw new IllegalArgumentException("Масив не повинен бути порожнім або null");
        }

        int maxLength = 1;
        int startIndex = 0;
        int currentLength = 1;

        for (int i = 1; i < numbers6.length; i++) {
            if (numbers6[i] > numbers6[i - 1]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = i - maxLength + 1;
                    System.out.println("i = " + i);
                    System.out.println("maxLength = " + maxLength);
                }
            } else {
                currentLength = 1;
            }
        }

        int[] result = Arrays.copyOfRange(numbers6, startIndex, startIndex + maxLength);
        System.out.println("numbers6 = " + Arrays.toString(numbers6));
        System.out.println("LongestIncreasingSequence = " + Arrays.toString(result));
        return result;
    }

// Метод для пошуку найбільшої спадної послідовності чисел
    public static int[] findLongestDecreasingSequence(int[] numbers7) {
        if (numbers7 == null || numbers7.length == 0) {
            throw new IllegalArgumentException("Масив не повинен бути порожнім або null");
        }

        int maxLength = 1;
        int startIndex = 0;
        int currentLength = 1;

        for (int i = 1; i < numbers7.length; i++) {
            if (numbers7[i] < numbers7[i - 1]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = i - maxLength + 1;
                }
            } else {
                currentLength = 1;
            }
        }

        int[] result = Arrays.copyOfRange(numbers7, startIndex, startIndex + maxLength);
        System.out.println("LongestDecreasingSequence = " + Arrays.toString(result));
        return result;
    }
}
