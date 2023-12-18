package yugo.start_oop;

public class Student extends BaseEntity{

    private String fullname;
    private int age;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' + "Student{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                '}';
    }
}
