package ua.com.alevel;

public class Student {

    String fName;
    String lName;
    int age;

    String fullName() {
        return fName + lName;
    }

    void setAge(int a){
        age = a;
    }
}


