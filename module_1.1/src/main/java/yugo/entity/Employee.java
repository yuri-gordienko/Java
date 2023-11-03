package yugo.entity;

import org.springframework.util.StringUtils;

public class Employee extends BaseEntity {

    private String name;
    private String surname;
    private int age;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()){
            System.out.println("You don't enter name!\n");
        } else {
            String nameName = StringUtils.capitalize(name);
            this.name = nameName;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.isBlank()){
            System.out.println("You don't enter surname!\n");
        } else {
            String nameSurname = StringUtils.capitalize(surname);
            this.surname = nameSurname;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        try {
            if (age >= 18 && age <= 50) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Age is not within the valid range (18-50)");
            }
        } finally { }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();
        if (email.matches( "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.email = email;
        } else {
            System.out.println("Incorrect e-mail!!!");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}' + super.toString();
    }
}
