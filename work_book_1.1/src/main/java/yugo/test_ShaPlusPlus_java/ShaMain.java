package yugo.test_ShaPlusPlus_java;

public class ShaMain {

    public static void main(String[] args) {

        int cornersSum = getCornersSum(1, 1);
        System.out.println("sum of corners = " + cornersSum);

        int sameNumbers = getSameNumbers(1, 1, 3);
        System.out.println("sameNumbers = " + sameNumbers);

        int divideWhen = getDivideWhen(20, 3, 10);
        System.out.println("divideTill = " + divideWhen);

        int numberBetweenZero = getNumberBetweenZero(new int[]{1, 0, 0, 3, 0}, 4);
        System.out.println("numberBetweenZero = " + numberBetweenZero);
    }


    public static int getCornersSum(int N, int K) {
        int triangleCorners = 3;
        int rhombusCorners = 4;

        int sum = triangleCorners * N + rhombusCorners * K;

        return sum;
    }

    public static int getSameNumbers(int a, int b, int c) {

//        if (a == b && a == c) {
//            return -1;
//        }
//
//        if (a == b) {
//            return c;
//        } else if (a == c) {
//            return b;
//        } else {
//            return a;
//        }

        return (a == b && a == c) ? -1 : (a == b ? c : (a == c ? b : a));
    }

    public static int getDivideWhen(int a, int b, int c) {

        while (a >= c) {
            a -= b;
//            a = a - b; // Заміна оператора -=
        }
        return a;
    }

    public static int getNumberBetweenZero(int[] array, int a) {

        for (int i = 0; i < a; i++) {
            if (array[i] == 0 && array[i + 2] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}