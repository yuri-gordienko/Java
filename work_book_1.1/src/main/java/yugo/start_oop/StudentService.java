package yugo.start_oop;

import java.util.Arrays;
import java.util.UUID;

public class StudentService {

    private Student[] students = new Student[5];

//    private String generateId() {
//        String id = String.valueOf(UUID.randomUUID());
//        for (Student student : students) {
//            if (student != null && id.equals(student.getId())) {
//                return generateId();
//            }
//        }
//        return id;
//    }

    public void create(Student student) {
//        student.setId(generateId());
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public Student[] allStudents() {
        return students;
    }

    public String stById(String id) {
        for (Student student : students) {
            if (student.getId() != null && id.equals(student.getId())) {
                return student.toString();
            }
        }
        return null;
    }

    public void update(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (student.getId().equals(students[i].getId())) {
                students[i] = student;
            }
        }
    }

    public Student delete(String id) {
        for (int i = 0; i < students.length; i++) {
            if (id.equals(students[i].getId())) {
                students[i] = null;
            }
            i++;
        }
        return null;
    }
}
