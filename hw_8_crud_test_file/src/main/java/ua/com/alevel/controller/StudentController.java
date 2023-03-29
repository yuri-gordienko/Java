package ua.com.alevel.controller;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.StudentDaoCsv;
import ua.com.alevel.entity.StudentCsv;
import ua.com.alevel.util.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static ua.com.alevel.dao.StudentDaoCsv.STUDENTS_DATA_BASE;
import static ua.com.alevel.dao.StudentDaoCsv.STUDENTS_DATA_BASE_STUDENTS;

public class StudentController {

    private StudentDao studentDao = new StudentDaoCsv();
    Color.Colors color = new Color.Colors();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("     ____________________________________________________ ");
        System.out.println("    | Hallo, Welcome to the STUDENTS Data base           |");
        System.out.println("    | Options >>                           if you want to:");
        String select;
        menu(color);
        createDir();
        while((select = bf.readLine()) != null) {
            variant(bf, select);
        }
    }

    private void menu(Color.Colors color) {
        System.out.println("    |----------------------------------------------------|");
        System.out.println("    CREATE student, please enter                         1");
        System.out.println("    UPDATE student, please enter                         2");
        System.out.println("    DELETE student, please enter                         3");
        System.out.println("    FIND student by ID, please enter                     4");
        System.out.println("    SEE all students, please enter                       5");
        System.out.println("    EXIT, please enter                                   0");
        System.out.println("    |....................................................|");
        System.out.println(color.RED + "    DELETE full STUDENTS DIRECTORY from your computer:  10" + color.WHITE);
        System.out.println("    |....................................................|");
    }

    private void variant(BufferedReader reader, String select) throws IOException {
        switch(select) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
            case "0" -> System.exit(0);
            case "10" -> deleteDir();
        }
        menu(color);
    }

    private void createDir() throws IOException {
        System.out.println(color.YELLOW + "The Directory and .CSV file have been created for recording your Data...");
        File dirs = new File(STUDENTS_DATA_BASE.toURI());
        File file = new File(STUDENTS_DATA_BASE_STUDENTS.toURI());
        file.getAbsolutePath();
        String path = file.getAbsolutePath();
        System.out.println(color.WHITE + ">>  " + path);
        dirs.mkdirs();
        file.createNewFile();
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter the first name:");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name:");
        String lastName = reader.readLine();
        System.out.println("Please enter the age:");
        String age = reader.readLine();
        StudentCsv st = new StudentCsv();
        st.setFirstName(firstName);
        st.setLastName(lastName);
        st.setAge(age);
        studentDao.create(st);
        System.out.println("Student was added!");
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of student whom you want to update: ");
        String id = reader.readLine();
        System.out.println("Please enter the first name:");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name:");
        String lastName = reader.readLine();
        System.out.println("Please enter the age:");
        String age = reader.readLine();
        StudentCsv st = studentDao.findById(id);
        st.setFirstName(firstName);
        st.setLastName(lastName);
        st.setAge(age);
        studentDao.update(st);
        System.out.println("Student was updated!");
    }

    public void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of student whom you want to delete: ");
        String id = reader.readLine();
        studentDao.delete(id);
        System.out.println("Student was deleted!");
    }

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of student whom you want to find: ");
        String id = reader.readLine();
        StudentCsv st = studentDao.findById(id);
        System.out.println("- " + st);
    }

    private void findAll() {
        System.out.println("Students List:");
        List<StudentCsv> students = studentDao.findAll();
        for (StudentCsv st : students) {
            System.out.println("- " + st);
        }
    }

    private void deleteDir() {
        studentDao.deleteDir();
    }
}
