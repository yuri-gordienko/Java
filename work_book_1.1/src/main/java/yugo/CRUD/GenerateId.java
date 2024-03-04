package yugo.CRUD;

import java.util.Arrays;
import java.util.UUID;

public class GenerateId {

    public static String generateId(Object[] objects) {
        String id = UUID.randomUUID().toString();

//        for (Object object : objectsStrings) {
//            if (object != null && object.getId().equals(id)) {
//                return generateId(objectsStrings);
//            }
//        }
//        System.out.println("\nlistIds = " + id);
//        return id;
//        ---------------------------------------------------
//        if (Arrays.stream(objectsStrings).anyMatch(object -> object.getId().equals(id) ?
//                generateId(objectsStrings) | return id;));

//        return Arrays.stream(objects).anyMatch(object -> object.getId().equals(id))
//                ? generateId(objects)
//                : id;
//        ------------------------------------------

        if (Arrays.stream(objects).anyMatch(object -> object.getId().equals(id))) {
            return generateId(objects); // Якщо умова виконується, рекурсивно викликаємо метод
        }
        System.out.println("\nlistIds = " + id);
        return id;

//        if (objectsStrings.stream().anyMatch(object -> object.getId().equals(id))) {
//            return generateId(objectsStrings);
//        }
    }
}
