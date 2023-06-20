package ua.com.alevel.controller;

import ua.com.alevel.persistence.entity.product.Clients;
import ua.com.alevel.persistence.repository.ClientsDao;
import ua.com.alevel.persistence.repository.impl.ClientsDaoImpl;
import ua.com.alevel.service.AccountsService;
import ua.com.alevel.service.ClientsService;
import ua.com.alevel.service.impl.AccountServiceImpl;
import ua.com.alevel.service.impl.ClientsServiceImpl;
import ua.com.alevel.util.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class ControllerClient {

    private static final ClientsService clientsService = new ClientsServiceImpl();
    private static final AccountsService accountsService = new AccountServiceImpl();
    private static final ClientsDao clientsDao = new ClientsDaoImpl();
    static Color.Colors color = new Color.Colors();

    public static void startMenuClient() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String select; menu(); while ((select = bf.readLine()) != null) {cases(bf, select);}
    }

    private static void menu() {
        System.out.println(color.YELLOW + "    +------------------------------------+");
        System.out.println(color.YELLOW + "    Create a client                >>>   1");
        System.out.println("    Update a client                >>>   2");
        System.out.println("    Delete a client                >>>   3");
        System.out.println("    Find   a client by ID          >>>   4");
        System.out.println("    See all clients                >>>   5");
        System.out.println(color.WHITE +"    Attach account to client       >>>   6");
        System.out.println("    Detach account from client     >>>   7");
        System.out.println(color.YELLOW + "    |....................................|");
        System.out.println(color.BLUE + "    Back                           <<<   9");
        System.out.println(color.RED + "    Close                           X    0");
        System.out.println(color.YELLOW + "    |____________________________________|");
    }

    private static void cases(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> createClient(reader);
            case "2" -> updateClient(reader);
            case "3" -> deleteClient(reader);
            case "4" -> findByIdClient(reader);
            case "5" -> seeAllClients();
            case "6" -> attachAccountToClient(reader);
            case "7" -> detachAccountFromClients(reader);
            case "9" -> back(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    private static void back(BufferedReader reader) throws IOException {
        ControllerMain.startApp();
    }

    private static void createClient(BufferedReader reader) throws IOException {
        System.out.println("Enter a first name:");
        String firstName = reader.readLine();
        System.out.println("Enter last name:");
        String lastName = reader.readLine();
        System.out.println("Enter age (from 18 to 110):");
        String stringAge = reader.readLine();
        Long age = (long) Integer.parseInt(stringAge);
        System.out.println("Enter e-mail:");
        String email = reader.readLine();
        Clients client = new Clients();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAge(age);
        client.setEmail(email);
        clientsService.create(client);
        System.out.println(color.CYAN + "Client was added successfully!" + color.YELLOW);
    }

    private static void updateClient(BufferedReader reader) throws IOException {
        System.out.println("Enter client's ID, you want to update: ");
        Long clientId = Long.valueOf(reader.readLine());
        System.out.println("Enter a first name:");
        String firstName = reader.readLine();
        System.out.println("Enter last name:");
        String lastName = reader.readLine();
        System.out.println("Enter age (from 18 to 110:");
        String stringAge = reader.readLine();
        Long age = (long) Integer.parseInt(stringAge);
        System.out.println("Enter e-mail:");
        String email = reader.readLine();
        Clients client = new Clients();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAge(age);
        client.setEmail(email);
        clientsService.update(client, clientId);
        System.out.println(color.CYAN + "Client was updated successfully!" + color.YELLOW);
    }

    public static void deleteClient(BufferedReader reader) throws IOException {
        try {
            System.out.println("Enter client's ID, you want to delete: ");
            Long clientId = Long.valueOf(reader.readLine());
            Clients client = clientsService.findById(clientId);
            clientsService.delete(client);
            System.out.println(color.RED + "Client was deleted!" + color.YELLOW);
        } catch (SecurityException e) {
            System.out.println("ID is incorrect, attempt another.");
        } catch (Exception e) {
            System.out.println("Unknown error.");
        }
    }

    private static void findByIdClient(BufferedReader reader) throws IOException {
        System.out.println("Enter client's ID, you want to find: ");
        Long clientId = Long.valueOf(reader.readLine());
        Clients client = clientsService.findById(clientId);
        if (client != null) {
            System.out.println(color.CYAN + "Client: " + color.WHITE + client + color.YELLOW);
        } else {
            System.out.println("ID is incorrect, check entered data.");
        }
    }

    private static void seeAllClients() {
        Collection<Clients> clients = clientsService.findAll();
        System.out.println(color.CYAN + "Clients:" + color.YELLOW);
        for (Clients client : clients) {
            if (client != null) {
                System.out.println(color.WHITE + client + color.YELLOW);
            }
        }
    }

        public static void attachAccountToClient(BufferedReader reader) throws IOException {
//        System.out.println("Enter client's ID to whom add account: ");
//        Long clientId = Long.valueOf(reader.readLine());
//        System.out.println("Enter account's ID, for attaching to client: ");
//        Long accountId = Long.valueOf(reader.readLine());
//        Clients clients = clientsService.findById(clientId);
//        Accounts accounts = accountsService.findById(accountId);
//        clientsDao.attachAccountsToClients(clients, accounts);
//        System.out.println(color.CYAN + "Account with ID: " + Long.valueOf(accountId) + " have been added to " +
//                "client with ID: " + clientId + color.YELLOW);
    }

    public static void detachAccountFromClients(BufferedReader reader) throws IOException {
//        System.out.println("Enter client's ID to whom delete account: ");
//        Long clientId = Long.valueOf(reader.readLine());
//        System.out.println("Enter account's ID, for dettaching from client: ");
//        Long accountId = Long.valueOf(reader.readLine());
//        Clients clients = clientsService.findById(clientId);
//        Accounts accounts = accountsService.findById(accountId);
//        clientsDao.detachAccountsFromClients(clients, accounts);
//        System.out.println(color.RED + "Account with ID: " + Long.valueOf(accountId) + " have been deleted from " +
//                "client with ID: " + clientId + color.YELLOW);
    }
}
