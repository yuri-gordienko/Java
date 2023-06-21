package ua.com.alevel.Jdbc_crud.entity;

import ua.com.alevel.Jdbc_crud.entity.BaseEntity;

public class Electives extends BaseEntity {

    private String name;

    public String getName() {

        return name;
    }

    public void setName(String firstName) {

        this.name = firstName;
    }

    public String toString() {

        return super.toString() + ", " + " Назва: " + name;
    }
}
