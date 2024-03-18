package yugo.CRUD;

public class Object extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' + "Object{" +
                "name='" + name + '\'' +
                '}';
    }
}
