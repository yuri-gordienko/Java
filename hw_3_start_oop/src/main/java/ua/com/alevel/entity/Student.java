package ua.com.alevel.entity;

public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phone;
    private int age;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18 && age < 50) {             // условия школы по возрасту
            this.age = age;
        }
        else {
            System.out.println("Student is not valid because of age!!!!!");
        }
    }

    public String toString() {
        String var1 = this.firstName;
        return "Student: firstName: " + firstName + ", lastName: " + lastName + ", phone: " + phone + ", age: " + age + ",  " + super.toString();
    }
}
