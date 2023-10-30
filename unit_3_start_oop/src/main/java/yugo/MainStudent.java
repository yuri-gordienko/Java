package yugo;

import yugo.controller.StudentController;

import java.io.IOException;

public class MainStudent {

    public static void main(String[] args) throws IOException {

        StudentController studentController = new StudentController();
        studentController.start();
    }
}