package ua.com.alevel;

import ua.com.alevel.controller.StudentController;

import java.io.IOException;

public class MainStudent {

    public static void main(String[] args) throws IOException {
        StudentController studentController = new StudentController();
        studentController.start();
    }
}