package ua.com.alevel;

import ua.com.alevel.controller.FileHelperController;

import java.io.IOException;

public class MainFileHelper {

    public static void main(String[] args) throws IOException {
        FileHelperController fileHelperController = new FileHelperController();
        fileHelperController.start();
    }
}