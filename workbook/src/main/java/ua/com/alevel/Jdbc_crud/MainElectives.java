package ua.com.alevel.Jdbc_crud;

import ua.com.alevel.controller.ElectivesController;

import java.io.IOException;

public class MainElectives {

    public static void main(String[] args) throws IOException {
        ElectivesController electivesController = new ElectivesController();
        electivesController.start();
    }
}