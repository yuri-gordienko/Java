package ua.com.alevel.controller;

import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.entity.product.Accounts;
import ua.com.alevel.persistence.entity.product.Clients;
import ua.com.alevel.persistence.repository.ClientsDao;
import ua.com.alevel.persistence.repository.impl.ClientsDaoImpl;
import ua.com.alevel.service.AccountsService;
import ua.com.alevel.service.ClientsService;
import ua.com.alevel.service.impl.AccountServiceImpl;
import ua.com.alevel.service.impl.ClientsServiceImpl;
import ua.com.alevel.util.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ua.com.alevel.persistence.enums.AccountStatement.Enum.HISTORY_FILE;
import static ua.com.alevel.persistence.enums.AccountsNamesEnum.Enum.*;
import static ua.com.alevel.persistence.enums.ClientsNamesEnum.Enum.*;

public class ControllerMain {

    private static final ClientsService clientsService = new ClientsServiceImpl();
    private static final AccountsService accountsService = new AccountServiceImpl();
    private static final ClientsDao clientsDao = new ClientsDaoImpl();
    static Color.Colors color = new Color.Colors();

    public static void startApp() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" ");
        System.out.println(color.BLUE + "     ____________________________________ ");
        System.out.println("    |              <goBANK>              |");
        System.out.println("    | All your transactions in one place |");
        addClients();
        addAccounts();
//        addAccountToClient();
//        historyFile();
        String select; menu(); while ((select = bf.readLine()) != null) {cases(bf, select);}
    }

    private static void menu() {
        System.out.println(color.PURPLE + "    |------------------------------------|");
        System.out.println(color.PURPLE + "    | Transfer money               >>>   1");
        System.out.println("    | Observe transactions history >>>   2");
        System.out.println("    |....................................|");
        System.out.println("    | Clients                      >>>   3");
        System.out.println("    | Accounts                     >>>   4");
        System.out.println("    |....................................|");
        System.out.println(color.PURPLE + "    |" +  color.YELLOW + " Clean history                >>>   5");
        System.out.println(color.PURPLE + "    |" +  color.RED + " Close                         X    0");
        System.out.println(color.PURPLE + "    |____________________________________| ");
        System.out.println(color.GREEN + "    Clients and Accounts have been uploaded" +
                     "\n    by system successfully, you can work..." + color.YELLOW);
    }

    private static void cases(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> tansferMoney(reader);
            case "2" -> transactionsHistory(reader);
            case "3" -> clients(reader);
            case "4" -> accounts(reader);
            case "5" -> cleanHistory(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    private static void tansferMoney(BufferedReader reader) throws IOException {    }

    private static void clients(BufferedReader reader) throws IOException {
        ControllerClient.startMenuClient();
    }

    private static void accounts(BufferedReader reader) throws IOException {
        ControllerAccount.startMenuAccount();
    }

    private static void addClients() {
        Clients client = new Clients();
        client.setFirstName(String.valueOf(BRUCE));
        client.setLastName(String.valueOf(LEE));
        client.setAge(22L);
        client.setEmail("brus@mail.com");
        clientsService.create(client);
        client.setFirstName(String.valueOf(CHUCK));
        client.setLastName(String.valueOf(NORRIS));
        client.setAge(28l);
        client.setEmail("chuck@mail.com");
        clientsService.create(client);
        client.setFirstName(String.valueOf(SYLVESTER));
        client.setLastName(String.valueOf(STALLONE));
        client.setAge(26l);
        client.setEmail("slay@mail.com");
        clientsService.create(client);
    }

    private static void addAccounts() {
        Accounts account = new Accounts();
        account.setBalance(NORRIS_PRIVAT_B);
        account.setBank(PRIVAT_B);
        accountsService.create(account);
        account.setBalance(NORRIS_SENSE_B);
        account.setBank(SENSE_B);
        accountsService.create(account);
        account.setBalance(SYLVESTER_PRIVAT_B);
        account.setBank(PRIVAT_B);
        accountsService.create(account);
        account.setBalance(SYLVESTER_PUMB_B);
        account.setBank(PUMB_B);
        accountsService.create(account);
        account.setBalance(SYLVESTER_SENSE_B);
        account.setBank(SENSE_B);
        accountsService.create(account);
    }

    private static void transactionsHistory(BufferedReader reader) throws IOException {
        File file = new File(HISTORY_FILE);
        System.out.println(color.CYAN + "Transactions history: \n>>  " + file.getAbsolutePath() + color.YELLOW);
        file.createNewFile();
        accountsService.exportToCsv();
    }

    private static void cleanHistory(BufferedReader reader) throws IOException {
        File file = new File(HISTORY_FILE);
        file.delete();
        System.out.println(color.RED + "History have been deleted" + color.YELLOW);
    }

//    public static void addAccountToClient() {
//        Clients clients = clientsService.findById(1L);
//        Accounts accounts = accountsService.findById(1L);
//        clientsDao.attachAccountsToClients(clients, accounts);
//        clients = clientsService.findById(1L);
//        accounts = accountsService.findById(2L);
//        clientsDao.attachAccountsToClients(clients, accounts);
//        clients = clientsService.findById(1L);
//        accounts = accountsService.findById(4L);
//        clientsDao.attachAccountsToClients(clients, accounts);
//
//        clients = clientsService.findById(2L);
//        accounts = accountsService.findById(1L);
//        clientsDao.attachAccountsToClients(clients, accounts);
//        clients = clientsService.findById(2L);
//        accounts = accountsService.findById(3L);
//        clientsDao.attachAccountsToClients(clients, accounts);
//
//        clients = clientsService.findById(3L);
//        accounts = accountsService.findById(1L);
//        clientsDao.attachAccountsToClients(clients, accounts);
//        clients = clientsService.findById(3L);
//        accounts = accountsService.findById(2L);
//        clientsDao.attachAccountsToClients(clients, accounts);
//        clients = clientsService.findById(3L);
//        accounts = accountsService.findById(3L);
//        clientsDao.attachAccountsToClients(clients, accounts);
//    }
}