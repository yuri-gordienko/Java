package ua.com.alevel.persistence.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "clients")
public class Clients extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Long age;


    @Column(name = "email", nullable = false, unique = true)
    @NotEmpty(message = "You have to enter an e-mail!")
    private String email;

//    @OneToMany(mappedBy = "client")
//    private List<Accounts> account;
//
//    public Clients() {
//        super();
//    }

//    @OneToMany(mappedBy = "client")
//    private Set<Accounts> account = new HashSet<>();
//
//    public Set<Accounts> getAccount() {
//        return account;
//    }
//
//    public void setAccount(Set<Accounts> account) {
//        this.account = account;
//    }

    public boolean setFirstName(String firstName) {
        boolean correctFirstName = false;
        if (firstName == "") {
            System.out.println("You don't enter a first name");
            return false;
        }
        if (firstName.matches(".*\\d.*") || firstName.equals("")) {
            System.out.println("This name is incorrect");
            System.out.println("Please, enter correct name, without symbols and numbers");
            System.out.println();
        } else {
            this.firstName = firstName;
            correctFirstName = true;
        }
        return correctFirstName;
    }

    public boolean setLastName(String lastName) {
        boolean correctLastName = false;
        if (firstName == "") {
            System.out.println("You don't enter a last name");
            return false;
        }
        if (lastName.matches(".*\\d.*") || lastName.equals("")) {
            System.out.println("This name is incorrect");
            System.out.println("Please, enter correct name, without symbols and numbers");
            System.out.println();
        } else {
            correctLastName = true;
            this.lastName = lastName;
        }
        return correctLastName;
    }

    public boolean setAge(Long age) {
        boolean correctAge = false;
        if (age >= 18 && age <= 110) {
            this.age = age;
            correctAge = true;
        } else {
            System.out.println("You entered incorrect data");
            System.out.println("Please, enter correct data");
            System.out.println();
        }
        return correctAge;
    }

    public boolean setEmail(String email) {
        boolean correctEmail = false;
        if (email.matches("^(.+)@(.+)$")) {
            this.email = email;
            correctEmail = true;
        } else {
            System.out.println("e-mail is incorrect");
            System.out.println("Please, enter correct an e-mail (example: name@mail.com)");
            System.out.println();
        }
        return correctEmail;
    }

    @Override
    public boolean equals(Object o) {

        return super.equals(o);
    }
//
//    @Override
//    public int hashCode() {
//
//        return super.hashCode();
//    }
}
