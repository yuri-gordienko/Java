package ua.com.alevel;

import ua.com.alevel.controller.ElectivesController;

import java.io.IOException;

public class HibernateMain {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Hibernate!");
        ElectivesController electivesController = new ElectivesController();
        electivesController.start();
    }
}
