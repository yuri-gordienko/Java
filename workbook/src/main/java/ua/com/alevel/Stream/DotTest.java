package ua.com.alevel.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DotTest {

    public void test() {
        List<String> stringList = Arrays.asList("1", "2", "te", "4", "9", "ihi");
        int sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
//                .mapToInt((Integer value) -> {
//                    return value;            // тривиальный способ (под капотом у лямбды)
//                    })
                .reduce(0, (a, b) -> this.sum(a, b));
//        System.out.println("sum = " + sum);

        sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                // оператор :: - ссылка на метод, когда совпадает порядок и типы аргументов, которые обрабатывает лямбда выражение,
                // совпадает последовательность этих аргументов в методе (см. в методе выше)
                .reduce(0, this::sum); // 1й вариант использовать :: - ссылаемся на метод текущего класса DotTest (вызов метода)
//        System.out.println("sum = " + sum);

        sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .reduce(0, MathUtil::sum); // 2й - ссылка на статический метод другого класса (в данном случае MathUtil)
        // т.к. MathUtil static нам не нужно делать new, напрямую вызываем метод
//        System.out.println("sum = " + sum);

        InnerClass innerClass = new InnerClass();   // новый отдельный класс
        sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .reduce(0, innerClass::sum); // 3й - ссылка на метод другого класса (может быть объявлен где угодно)
//        System.out.println("sum = " + sum);


        List<User> users = getUsers();  // получаем список пользователей (тривиальный способ)
        for (User user : users) {
            System.out.println("user = " + user);
        }
        List<UserDTO> userDTOList = new ArrayList<>();  // на базе этого массива создаем Лист ДТО
        for (User user : users) {
//            UserDTO userDTO = new UserDTO();  // тривиальный способ
//            userDTO.setEmail(user.getEmail());
//            userDTO.setFirstName(user.getFirstName());
//            userDTO.setLastName(user.getLastName());
//            userDTOList.add(userDTO);
            userDTOList.add(new UserDTO(user));     // новый способ
        }
        System.out.println();

        userDTOList = users                     // способ на основании Стрима
                .stream()
//                .map(user -> new UserDTO(user))   // используем лямбду
                .map(UserDTO::new)  // используем оператор ::
                .toList();

        for (UserDTO userDTO : userDTOList) {           // выводим сформированный Лист ДТО
            System.out.println("userDTO = " + userDTO);
        }
    }

    private int sum(int a, int b) {     // существующий метод в классе, на основании которого использовали лямбду
        return a + b;
    }

    private List<User> getUsers() {                 // создали пользователей вручную
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setEmail("user" + i + "@mail.com");
            user.setFirstName("first" + i);
            user.setLastName("last" + i);
            user.setPassword(UUID.randomUUID().toString());
            users.add(user);
        }
        return users;
    }

    private class InnerClass {                              // внутренний клас, на основании которого использовали лямбду
        private int sum(int a, int b) {
            return a + b;
        }
    }
}