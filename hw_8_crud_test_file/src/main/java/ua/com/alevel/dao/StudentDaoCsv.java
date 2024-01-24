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
    // Имплементация классом интерфейса — это гарантия реализации функционала. Если класс имплементирует некоторый
    // интерфейс, то он обещает, что в нем есть объявленные в интерфейсе методы, они принимают объявленные параметры и
    // возвращает объявленное значение

    public static final File STUDENTS_DATA_BASE = new File("STUDIENTS_Data_Base");
    public static final File STUDENTS_DATA_BASE_STUDENTS = new File("STUDIENTS_Data_Base/students.csv");


    // приняли на вход студента, сгенерировали id, теперь нужно его записать в файл
    // но для того, чтоб записать нужно иметь коллекцию
    private List<StudentCsv> students = new ArrayList<>();       // инициализируем студентов

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

    private void initStudents() {           // чтоб считать данные с файла используем метод от библиотеки opencsv
        // используем try чтоб файл закрылся после чтения (файл нужно закрывать)
        try (CSVReader csvReader = new CSVReader(new FileReader(STUDENTS_DATA_BASE_STUDENTS))) {// ридер работает как декоратор, читаем данные с файла .csv
            List<String[]> list = csvReader.readAll();      // достаем лист массива строк (readAll возвращает лист массива строк)
            students = new ArrayList<>();   // на базе листа инициализируем студентов, при каждом чтении говорим что наши студенты это новый список
            if (CollectionUtils.isNotEmpty(list)) {     // если считали данные и файл не пуустой
                for (String[] element : list) {     // бежим по листу (массив элементов строк)
                    StudentCsv student = new StudentCsv();
                    student.setId(element[0]);      // кладем в ячейку значение
                    student.setFirstName(element[1]);
                    student.setLastName(element[2]);
                    student.setAge(Integer.parseInt(element[3]));
                    students.add(student);      // создаем коллекцию студентов у нас на компе локально
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void wrightStudentsToCSV() {            // сохранить данные
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(STUDENTS_DATA_BASE_STUDENTS))) {    // записываем данные в файл
            List<String[]> list = new ArrayList<>(); // считали лист массива строк, теперь создаем лист массива строк
            if (CollectionUtils.isNotEmpty(students)) { // если коллекция не пустая
                for (StudentCsv student : students) {
                    String[] st = new String[] {       // создаем на каждом этапе массив строки
                            student.getId(),
                            student.getFirstName(),
                            student.getLastName(),
                            String.valueOf(student.getAge())
                    };
                    list.add(st);       // в наш лист добавляем переменную
                }
                csvWriter.writeAll(list);       // после того как сгенерировали, записываем лист массива строк
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
