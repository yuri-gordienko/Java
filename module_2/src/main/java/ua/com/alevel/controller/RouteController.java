package ua.com.alevel.controller;

import ua.com.alevel.service.RouteService;
import ua.com.alevel.util.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RouteController {

    public static int departurePoint;
    public static int destination;

    private RouteService routeService = new RouteService();
    Color.Colors color = new Color.Colors();

    public void startApp() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("     _____________________________________________________ ");
        System.out.println(color.PURPLE + "    |Hallo, We greet you in <goTrip> app ;)               |");
        System.out.println("    |We help you to calculate the best route for your trip|");
        String select;
        menu(color);
        while((select = bf.readLine()) != null) {
            cases(bf, select);
        }
    }

    private void menu(Color.Colors color) {
        System.out.println(color.WHITE + "    |-----------------------------------------------------|");
        System.out.println(color.YELLOW + "    BUILD the route                                 >>>   1");
        System.out.println("    Calculate route                                 >>>   2");
        System.out.println(color.WHITE + "    Clean information from your computer            >>>   3");
        System.out.println("    |.....................................................|");
        System.out.println(color.RED + "    EXIT                                            >>>   0");
        System.out.println(color.WHITE + "    |.....................................................|");
        System.out.println("Information for planing trip have been sent to your e-mail, check your box, please...");
        System.out.println("File_PATH: ../java_5_online/module_2/input.txt" + color.WHITE);
    }

    private void cases(BufferedReader reader, String select) throws IOException {
        switch(select) {
            case "1" -> build(reader);
            case "2" -> calculate(reader);
            case "3" -> clean(reader);
            case "0" -> System.exit(0);
        }
        menu(color);
    }

    private void build(BufferedReader reader) throws IOException {
        System.out.println("Please, enter № of Departure point of your trip (according our offer in java_5_online/module_2/input.txt:");
        String dep = reader.readLine();
        System.out.println("Please, enter № of Destination of your trip (according our offer in java_5_online/module_2/input.txt:");
        String dest = reader.readLine();
        this.departurePoint = Integer.parseInt(dep);
        this.destination = Integer.parseInt(dest);
    }

    private void calculate(BufferedReader reader) throws IOException {
        routeService.matrix();
    }

    private void clean(BufferedReader reader) throws IOException {
        routeService.deleteOutputFile();
    }
}
