package ua.com.alevel;

import ua.com.alevel.controller.ControllerMain;

import java.io.IOException;

public class BankingMain {

    public static void main(String[] args) throws IOException {
        ControllerMain controllerMain = new ControllerMain();
        controllerMain.startApp();
    }
}