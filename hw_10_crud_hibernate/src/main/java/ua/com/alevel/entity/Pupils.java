package ua.com.alevel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity // класс мапится на таблицу
@Table(name = "pupils")
public class Pupils extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "class")
    private Integer mark;

    @Column(name = "email", nullable = false, unique = true) // колонка неможет быть пустая, уникальнай адрес
    private String email;

    @ManyToMany(mappedBy = "pupil") // mappedBy - на какую таблицу pupils мы будем ссылаться в Electives (имя учеников в факультативе)
    private Set<Electives> elective = new HashSet<>();

    public String getFirstName() {

        return firstName;
    }

    public boolean setFirstName(String firstName) {
        boolean correctFirstName = false;
        if (firstName == "") {
            System.out.println("Ви не ввели ім'я");
            return false;
        }
        if (firstName.matches(".*\\d.*") || firstName.equals("")) {
            System.out.println("Таке ім'я не коректне");
            System.out.println("Будь ласка, введіть коректне ім'я, без символів та цифр");
            System.out.println();
        } else {
            this.firstName = firstName;
            correctFirstName = true;
        }
        return correctFirstName;
    }

    public String getLastName() {

        return lastName;
    }

    public boolean setLastName(String lastName) {
        boolean correctLastName = false;
        if (firstName == "") {
            System.out.println("Ви не ввели призвище");
            return false;
        }
        if (lastName.matches(".*\\d.*") || lastName.equals("")) {
            System.out.println("Таке призвище не коректне");
            System.out.println("Будь ласка, введіть коректне призвище");
            System.out.println();
        } else {
            correctLastName = true;
            this.lastName = lastName;
        }
        return correctLastName;
    }

    public Integer getMark() {

        return mark;
    }

    public boolean setMark(Integer mark) {
        boolean correctMark = false;
        if (mark >= 1 && mark <= 5) {
            this.mark = mark;
            correctMark = true;
        } else {
            System.out.println("Ви ввели не існуючу оцінку");
            System.out.println("Будь ласка, введіть коректну оцінку");
            System.out.println();
        }
        return correctMark;
    }

    public String getEmail() {

        return email;
    }

    public boolean setEmail(String email) {
        boolean correctEmail = false;
        if (email.matches("^(.+)@(.+)$")) {
            this.email = email;
            correctEmail = true;
        } else {
            System.out.println("e-mail не коректний");
            System.out.println("Будь ласка, введіть коректний e-mail (наприклад: name@mail.com)");
            System.out.println();
        }
        return correctEmail;
    }

    public Set<Electives> getElctive() {

        return elective;
    }

    public void setElctive(Set<Electives> elctive) {

        this.elective = elctive;
    }

    @Override
    public boolean equals(Object o) {

        return super.equals(o);
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + ", " + " ПІБ: " + firstName + ", " + lastName + "; " +
               " Оцінка: " + mark + "; " + " e-mail: " + email + "; " +
                " Студента оновлено: " +  getUpdated();
    }
}
