package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

import java.util.UUID;

public class StudentService {

    private Student[] students = new Student[2];

    int arrayGrowth;
    private void addIndex() {                           // метод по увеличению массива при заполнении
        if (arrayGrowth == students.length) {
            Student[] addSt = new Student[(students.length + students.length)];
            for (int i = 0; i < students.length; i++) {
                addSt[i] = students[i];
            }
            students = addSt;
        }
    }

    public void create(Student student) {
        student.setId(generateId());
        addIndex();                                     // вызываю метод по увеличению массива при заполнении
        for(int i = 0; i < students.length; i++) {
           if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
        arrayGrowth++;
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
        for(int i = 0; i < students.length; i++) {                    // перебираем массив
            try {                                                     // определяю блок кода, в котором может произойти исключение
                if (students[i].getId().equals(student.getId())) {    // если в массиве индекс с присвоенным id соответствует введенному в поиске id
                    students[i] = student;                            // то выводим студента
                }
            }
            catch (Exception e) {                                     // определяю блок кода, в котором происходит обработка исключения и пишем обработку исключения при закрытии потока чтения
                i++;                                                  // переходим далее
            }
        }
    }

    public Student delete(String id) {
        for(int i = 0; i < students.length; i++) {
            try {
                if (students[i].getId().equals(id)) {
                    students[i] = null;
                }
            }
            catch (Exception e) {
                i++;
            }
        }
        return null;
    }

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

