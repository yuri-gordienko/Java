package ua.com.alevel;

import ua.com.alevel.controller.ControllerStream;

import java.io.IOException;

public class MainStream {

    public static void main(String[] args) throws IOException {
        ControllerStream controllerStream = new ControllerStream();
        controllerStream.start();
    }
}