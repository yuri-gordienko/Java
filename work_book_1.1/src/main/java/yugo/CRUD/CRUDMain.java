package yugo.CRUD;

public class CRUDMain {

    public static void main(String[] args) {

        CRUDService crudService = new CRUDService();

//        create
        Object object = new Object();
        object.setId("1");
        object.setName("object_1");
        crudService.create(object);

        Object object2 = new Object();
        object2.setId(crudService.generateID());
        object2.setName("object_2");
        crudService.create(object2);

        Object object3 = new Object();
        String id = crudService.generateID();
        object3.setId(id);
        object3.setName("object_3");
        crudService.create(object3);

        Object object1 = new Object();
        object1.setId("1");
        object1.setName("object_1.1");
        crudService.create(object1);

//        readALL
        Object[] objectsStrings = crudService.readAll();
        for (Object s : objectsStrings) {
            if (s != null) {
                System.out.println("readALL " + s);
            }
        }

//        readById
        crudService.readById("1");

//        update
        Object updated = crudService.readById("1");
        updated.setName("1.updated");
        crudService.update(updated);

        Object[] objectsStrings2 = crudService.readAll();
        for (Object s : objectsStrings2) {
            if (s != null) {
                System.out.println("readALL " + s);
            }
        }

//        delete
        crudService.delete("1");
        Object[] objectsStrings3 = crudService.readAll();
        for (Object s : objectsStrings3) {
            if (s != null) {
                System.out.println("delete " + s);
            }
        }
    }
}
