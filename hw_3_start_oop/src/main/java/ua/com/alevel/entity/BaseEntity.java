package ua.com.alevel.entity;

public abstract class BaseEntity extends Object {

    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "BaseEntity {id: " + this.id + "}";
    }
}