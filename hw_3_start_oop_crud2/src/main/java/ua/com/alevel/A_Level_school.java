package ua.com.alevel;

import ua.com.alevel.controller.StudentController;
import java.io.IOException;

public class A_Level_school {

    public static void main(String[] args) throws IOException {

        StudentController studentController = new StudentController();
        studentController.start();
    }
}
