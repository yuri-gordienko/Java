package yugo.controller;

import yugo.entity.Student;
import yugo.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentController {

    private StudentService studentService = new StudentService();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nStudents data base:\n");

        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            crud(bf, select);
        }
    }

    private void menu() {
        System.out.println("You can choose any action:");
        System.out.println("Create student        -> 1");
        System.out.println("Update student        -> 2");
        System.out.println("Delete student        -> 3");
        System.out.println("Find student by id    -> 4");
        System.out.println("Find all students     -> 5");
        System.out.println("Exit                  -> 6");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
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
        Student student = new Student();
        System.out.println("Enter name:");
        String name = reader.readLine();
        System.out.println("Enter surname");
        String surname = reader.readLine();
        System.out.println("Enter age");
        String age = reader.readLine();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(Integer.parseInt(age));
        studentService.create(student);
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("Enter ID:");
        String id = reader.readLine();
        Student student = studentService.findById(id);
        System.out.println("New name:");
        String name = reader.readLine();
        student.setName(name);
        System.out.println("New surname:");
        String surname = reader.readLine();
        student.setSurname(surname);
        System.out.println("New age:");
        String age = reader.readLine();
        student.setAge(Integer.parseInt(age));
        studentService.update(student);
    }

    private void delete(BufferedReader reader) throws IOException {
        System.out.println("Enter ID:");
        String id = reader.readLine();
        studentService.delete(id);
    }

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Enter ID:");
        String id = reader.readLine();
        Student student = studentService.findById(id);
        System.out.println("Student by id - " + student + "\n");
    }

    private void findAll() {
        Student[] students = studentService.findAll();
        for (Student student : students) {
            System.out.println("- " + student);
        }
    }
}
