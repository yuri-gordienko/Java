package ua.com.alevel.String;

public class StringConcat {

    public static void main(String[] args) {

        // метод concatenation занимает много места в памяти, т.к. постоянно перезаписывает строку через каждых 2 объекта
        // но его быстрее написать, подходит для небольшого кол-ва инфо
        String concatenation = "Hello " + "world " + 15 + " " + true + " " + 2.14;
        System.out.println(concatenation);

        // StringBuilder более долго писать, но занимает меньше места в памяти, добавляя объекты по одному
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ")
                .append("world ")
                .append(15)
                .append(" ")
                .append(true)
                .append(" ")
                .append(2.14);
        System.out.println(sb);
    }
}
