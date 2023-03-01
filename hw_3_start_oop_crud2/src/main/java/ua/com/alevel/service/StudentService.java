package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

import java.util.UUID;

public class StudentService {

    private Student[] students = new Student[3];

        public void create(Student student) {
            student.setId(generateId());
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    break;
                }
            }
        }
        private String generateId() {
            String id = UUID.randomUUID().toString();
            for (Student student : students) {
                if (student != null && student.getId().equals(id)) {
                    return generateId();
                }
            }
            return id;
        }
        public void update(Student student) {
            for (int i = 0; i < students.length; i++) {
                try {
                    if (students[i].getId().equals(student.getId())) {
                        students[i] = student;
                    }
                }
                catch (Exception e) {
                i++;
                }
            }
        }
        public void delete(String id) {
            for (int i = 0; i < students.length; i++) {
                try {
                    if (students[i].getId().equals(id)) {
                        students[i] = null;
                    }
                }
                catch (Exception e) {
//                i++;
                 }
            }
        }

    //                   System.out.println("The student was deleted " + del);


        public Student findById(String id) {
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    return student;
                }
            }
            return null;
        }
        public Student[] findAll() {
            return students;
        }
}