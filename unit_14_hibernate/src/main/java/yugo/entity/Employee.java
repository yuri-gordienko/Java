package yugo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees") // а вот без этой аннотации обойтись можно, по дефолту Hibernate будет называть именем джава класса
public class Employee extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private int age;

    @ManyToMany(mappedBy = "employees")
    private Set<Department> departments = new HashSet<>();

//    @ManyToMany - може бути багато працівників, і кожен з них може бути у багатьох департаментах
//    mappedBy = "employees" - можна не ставити (пояснюємо Hibernate на який філд працівника (Set<Employee> employees)
//    будемо ссилатися у департамеенті



//    @OneToMany
//    private Set<Branch> branches;
//        Привʼязуємо багато філій до керівника, один курівник - багато філій
//        потрібно робити Set<Branch>, якщо ми у класі де одна ентіті, до якої привʼзуємо багато ентітей
//        то краще в класі там де багато ентітей (Branch) зробити звʼязок @ManyToOne, тоді Set не потрібен
//        в такому випадку обидві таблиці знають одна про одну,
//        тому буде потрібна 3тя таблиця, тому що у таблицю Employee ми не засунемо список id-шників

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
