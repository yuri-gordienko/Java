package yugo.CRUD;

import java.util.List;
import java.util.UUID;

public class GenerateId {

    public static String generateId(List<Object> objectsStrings) {
        String id = UUID.randomUUID().toString();

        if (objectsStrings.stream().anyMatch(object -> object != null && id.equals(object.getId()))) {
            return generateId(objectsStrings);
        }
        return id;
    }
}
