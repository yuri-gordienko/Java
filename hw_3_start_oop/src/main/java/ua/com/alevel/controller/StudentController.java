package ua.com.alevel.controller;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StudentController {

    private StudentService studentService = new StudentService();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("*************************************************************************************************************************************");
        System.out.println("Hallo, Welcome to the STUDENTS Data_base. Please, Select your option:");
        String select;
        menu();
        while((select = bf.readLine()) != null) {
            variant(bf, select);
        }
    }

    private void menu() {
        System.out.println("_____________________________________________________________________");
        System.out.println("If you want to CREATE student, please enter         1");
        System.out.println("If you want to UPDATE student, please enter         2");
        System.out.println("If you want to DELETE student, please enter         3");
        System.out.println("If you want to FIND student by ID, please enter     4");
        System.out.println("If you want to SEE all students, please enter       5");
        System.out.println("If you want to EXIT, please enter                   6");
    }

    private void variant(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
            case "6" -> System.exit(0);
        }
        menu();
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter the first name:");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name:");
        String lastName = reader.readLine();
        System.out.println("Please enter the phone:");
        String phone = reader.readLine();
        System.out.println("Please enter the age:");
        String stringAge = reader.readLine();
        int age = Integer.parseInt(stringAge);
        Student st = new Student();
        st.setFirstName(firstName);
        st.setLastName(lastName);
        st.setPhone(phone);
        st.setAge(age);
        studentService.create(st);
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of student whom you want to update: ");
        String id = reader.readLine();
        System.out.println("Please enter the first name:");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name:");
        String lastName = reader.readLine();
        System.out.println("Please enter the phone:");
        String phone = reader.readLine();
        System.out.println("Please enter the age:");
        int age = Integer.parseInt(reader.readLine());
        Student st = studentService.findById(id);
        st.setFirstName(firstName);
        st.setLastName(lastName);
        st.setPhone(phone);
        st.setAge(age);
        studentService.update(st);
    }

    public void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of student whom you want to delete: ");
        String id = reader.readLine();
        studentService.delete(id);
        System.out.println("Student was deleted!");
    }

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of student whom you want to find: ");
        String id = reader.readLine();
        Student st = studentService.findById(id);
        System.out.println("- " + st);
    }

    private void findAll() {
        Student[] students = studentService.findAll();
        for (Student st : students) {
            System.out.println("- " + st);
        }
    }
}
