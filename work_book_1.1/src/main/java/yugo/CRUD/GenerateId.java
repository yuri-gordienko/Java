package yugo.CRUD;

import java.util.Arrays;
import java.util.UUID;

public class GenerateId {

    public static String generateIds(Object[] objects) {
        String id = UUID.randomUUID().toString();

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null && id.equals(objects[i].getId())) {
                generateIds(objects);
            }
        }
        System.out.println("\nlistIds = " + id);
        return id;
//        -------------------------------------------------------------

//        for (Object object : objects) {
//            if (object != null && object.getId().equals(id)) {
//                return generateIds(objects);
//            }
//        }
//        System.out.println("\nlistIds = " + id);
//        return id;
//        ------------------------------------------

//        if (Arrays.stream(objects).anyMatch(object -> object != null && object.getId().equals(id))) {
//            return generateIds(objects);
//        }
//        System.out.println("\nlistIds = " + id);
//        return id;
//        --------------------------------------------------
//        System.out.println("\nlistIds = " + id);
//        return Arrays.stream(objects).anyMatch(object -> object != null && object.getId().equals(id))
//                ? generateIds(objects) : id;
    }
}
