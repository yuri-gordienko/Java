package ua.com.alevel.String;

public class StringBasic {

    public static void main(String[] args) {

        String name = "Yura";
        String name2 = "";
        String name3 = "Hello world";

        char[] chars = name.toCharArray();
        for (char i = 0; i < chars.length; i++){
            System.out.println(chars[i]);
        }
        chars[0] = 'y';
        chars[1] = 'U';
        String newName = new String(chars);
        System.out.println(newName);


        String newNameUpper = newName.toUpperCase();
        System.out.println(newNameUpper);

        boolean isEmpty = name.isEmpty();
        System.out.println(isEmpty);

        boolean isEmpty2 = name2.isEmpty();
        System.out.println(isEmpty2);

        String subs = name3.substring(4, 8);
        System.out.println(subs);

        // we have some String = "password=abc123 or login=Yura
        // return value after =
        String first = "password=abc123";
        String second = "login=Yura";

        String password = first.substring(9);
        int login = second.indexOf('=');
        System.out.println(password);
        System.out.println(login);
        //____________________________________________________

        String passValue = getValue(first);
        String logVAlue = getValue(second);
        System.out.println("passw: " + passValue + ",\n  log: " + logVAlue);

    }

    public static String getValue(String value) {
        int indexOf = value.indexOf('='); // получаем номер элемента по который хотим обрезать, чтоб не считать вручную
        String subs = value.substring(indexOf + 1); // т.к обрезает до знака индекса, добавляем еще один знак

        return subs;
    }
}