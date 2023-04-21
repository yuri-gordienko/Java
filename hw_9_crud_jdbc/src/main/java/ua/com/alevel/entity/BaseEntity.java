package ua.com.alevel.entity;

public abstract class BaseEntity {

    private Long id;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String toString() {

        return "> ID: " + id;
    }
}
