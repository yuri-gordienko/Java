package ua.com.alevel;

import ua.com.alevel.controller.ElectivesController;

import java.io.IOException;

public class ElectivesMain {

    public static void main(String[] args) throws IOException {
        ElectivesController electivesController = new ElectivesController();
        electivesController.start();
    }
}