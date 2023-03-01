package ua.com.alevel;

import java.io.IOException;
import ua.com.alevel.controller.StudentController;

public class School_Main {

    public static void main(String[] args) throws IOException {
        StudentController studentController = new StudentController();
        studentController.start();
    }
}