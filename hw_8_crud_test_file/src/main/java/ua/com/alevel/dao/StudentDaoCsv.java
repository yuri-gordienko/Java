package ua.com.alevel.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.entity.StudentCsv;
import ua.com.alevel.util.DbUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoCsv implements StudentDao {

    public static final File STUDENTS_DATA_BASE = new File("STUDIENTS_Data_Base");
    public static final File STUDENTS_DATA_BASE_STUDENTS = new File("STUDIENTS_Data_Base/students.csv");

    private List<StudentCsv> students = new ArrayList<>();

    @Override
    public void create(StudentCsv student) {
        initStudents();
        student.setId(DbUtil.getInstance().generateId(students));
        students.add(student);
        wrightStudentsToCSV();
    }

    @Override
    public void update(StudentCsv student) {
        initStudents();
        for(int i = 0; i < students.size(); i++) {
            try {
                if (students.get(i).getId().equals(student.getId())) {
                    students.set(i, student);
                }
            }
            catch (Exception e) {
                i++;
            }
        }
        wrightStudentsToCSV();
    }

    @Override
    public void delete(String id) {
        initStudents();
        students.removeIf(student -> student.getId().equals(id));
        wrightStudentsToCSV();
    }

    @Override
    public StudentCsv findById(String id) {
        initStudents();
        for (StudentCsv student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<StudentCsv> findAll() {
        initStudents();
        return students;
    }

    private void initStudents() {
        try (CSVReader csvReader = new CSVReader(new FileReader(STUDENTS_DATA_BASE_STUDENTS))) {
            List<String[]> list = csvReader.readAll();
            students = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(list)) {
                for (String[] element : list) {
                    StudentCsv student = new StudentCsv();
                    student.setId(element[0]);
                    student.setFirstName(element[1]);
                    student.setLastName(element[2]);
                    student.setAge(Integer.parseInt(element[3]));
                    students.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void wrightStudentsToCSV() {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(STUDENTS_DATA_BASE_STUDENTS))) {
            List<String[]> list = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(students)) {
                for (StudentCsv student : students) {
                    String [] st = new String[] {
                            student.getId(),
                            student.getFirstName(),
                            student.getLastName(),
                            String.valueOf(student.getAge())
                    };
                    list.add(st);
                }
                csvWriter.writeAll(list);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
