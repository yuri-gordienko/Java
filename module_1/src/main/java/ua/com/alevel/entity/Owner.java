package ua.com.alevel.entity;

public class Owner extends BaseEntity {

    private String firstName;
    private String lastName;

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

    @Override
    public String toString() {
        return
                "id - " + getId() + '\'' + "; " +
                        "First name: " + firstName + '\'' + "; " +
                        "Last name: " + lastName + '\'' + "; " +
                        " " + super.toString();
    }
}
