package ua.com.alevel.dao;

import ua.com.alevel.entity.StudentCsv;

import java.util.List;

public interface StudentDao {
    void create(StudentCsv student);
    void update(StudentCsv student);
    void delete(String id);
    StudentCsv findById(String id);
    List<StudentCsv> findAll();
}
