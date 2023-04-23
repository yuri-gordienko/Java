package ua.com.alevel.Jdbc_crud.entity;

import ua.com.alevel.entity.BaseEntity;

public class Pupils extends BaseEntity {

    private String firstName;
    private String lastName;
    private int clas;
    private String email;

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public int getClas() {

        return clas;
    }

    public void setClas(int clas) {

        this.clas = clas;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String toString() {
        return super.toString() + ", " + " ПІБ: " + firstName + ", " + lastName + "; " +
               " Клас: " + clas + "; " + " e-mail: " + email + " ";
    }
}
