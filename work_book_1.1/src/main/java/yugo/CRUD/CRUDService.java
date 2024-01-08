package yugo.CRUD;

import java.util.UUID;

public class CRUDService {

    private Object[] objects = new Object[10];

    public String generateID() {
        String id = String.valueOf(UUID.randomUUID());
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null && objects[i].getId().equals(id)) {
                return generateID();
            }
        }
        return id;
    }

    public void create(Object ob) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = ob;
                break;
            }
            if (objects[i] !=null && ob.getId().equals("1")) {
                objects[i] = ob;
                break;
            }
        }
    }

    public Object[] readAll() {
        return objects;
    }

    public Object readById (String id) {
        for (Object object : objects) {
            if (id.equals(object.getId())) {
                System.out.println("\nreadById " + object);
                return object;
            }
        }
        return null;
    }

    public void update(Object object) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null && objects[i].getId().equals(object.getId())) {
                objects[i] = object;
                System.out.println("\nupdatedOb " + object);
            }
        }
    }

    public Object delete(String id) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null && id.equals(objects[i].getId())) {
                System.out.println("\ndeleted by id " + id);
                objects[i] = null;
            }
            i++;
        }
        return null;
    }



}
