package ua.com.alevel;

import ua.com.alevel.controller.DataBaseController;

import java.io.IOException;

public class DataBaseMain {

    public static void main(String[] args) throws IOException {

        DataBaseController dataController = new DataBaseController();
        dataController.start();
    }
}