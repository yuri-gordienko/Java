package yugo.service;

import yugo.entity.Student;

import java.util.UUID;

public class StudentService {

    private Student[] students = new Student[2];

    int arraySize;
    public void create(Student student){
        student.setId(generateId());

        if (arraySize == students.length) {
            Student[] newStudents = new Student[students.length * 2];
            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i]; // копіювання елементів
            }
            students = newStudents; // посилання старого масива на новий
        }
//        students[arraySize] = student; // Додавання студента до масиву

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {  // можно і не перевіряти, все одно записує
                students[i] = student;
                break;
            }
        }
        arraySize++;
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

    public Student findById (String id) {
        for (Student student : students) {
            if (id.equals(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public Student[] findAll() {
        return students;
    }

    public String generateId() {
        String id = String.valueOf(UUID.randomUUID());
        for (Student student : students) {
            if (student != null && student.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
