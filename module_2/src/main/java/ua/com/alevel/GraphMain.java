package ua.com.alevel;

import ua.com.alevel.controller.RouteController;

import java.io.IOException;

public class GraphMain {

    public static void main(String[] args) throws IOException {
        RouteController RouteController = new RouteController();
        RouteController.startApp();
    }
}
