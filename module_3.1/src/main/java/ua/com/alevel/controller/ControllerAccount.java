package ua.com.alevel.controller;

import ua.com.alevel.persistence.entity.product.Accounts;
import ua.com.alevel.service.AccountsService;
import ua.com.alevel.service.impl.AccountServiceImpl;
import ua.com.alevel.util.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class ControllerAccount {

    private static final AccountsService accountsService = new AccountServiceImpl();
    static Color.Colors color = new Color.Colors();

    public static void startMenuAccount() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      String select; menu(); while ((select = bf.readLine()) != null) {cases(bf, select);}
    }

    public static void menu() {
        System.out.println(color.YELLOW + "    +------------------------------------+");
        System.out.println(color.YELLOW + "    Create an account              >>>   1");
        System.out.println("    Update an account              >>>   2");
        System.out.println("    Delete an account              >>>   3");
        System.out.println("    Find   an account by ID        >>>   4");
        System.out.println("    See all accounts               >>>   5");
        System.out.println(color.YELLOW + "    |....................................|");
        System.out.println(color.BLUE + "    Back                           <<<   9");
        System.out.println(color.RED + "    Close                           X    0");
        System.out.println(color.YELLOW + "    |____________________________________|");
    }

    private static void cases(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> createAccount(reader);
            case "2" -> updateAccount(reader);
            case "3" -> deleteAccount(reader);
            case "4" -> findByIdAccount(reader);
            case "5" -> seeAllAccounts();
            case "9" -> back(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }
    private static void back(BufferedReader reader) throws IOException {
        ControllerMain.startApp();
    }

    private static void createAccount(BufferedReader reader) throws IOException {
        System.out.println("Enter a balance:");
        String balance = reader.readLine();
        Long bal = (long) Integer.parseInt(balance);
        System.out.println("Enter Bank name:");
        String bank = reader.readLine();
        Accounts account = new Accounts();
        account.setBalance(bal);
        account.setBank(bank);
        accountsService.create(account);
        System.out.println(color.CYAN + "Account was added successfully!" + color.YELLOW);
    }

    private static void updateAccount(BufferedReader reader) throws IOException {
        System.out.println("Enter account's ID, you want to update: ");
        Long acId = Long.valueOf(reader.readLine());
        System.out.println("Enter a balance:");
        String balance = reader.readLine();
        Long bal = (long) Integer.parseInt(balance);
        System.out.println("Enter Bank name:");
        String bank = reader.readLine();
        Accounts account = new Accounts();
        account.setBalance(bal);
        account.setBank(bank);
        accountsService.update(account, acId);
        System.out.println(color.CYAN + "Account was updated successfully!" + color.YELLOW);
    }

    public static void deleteAccount(BufferedReader reader) throws IOException {
        try {
            System.out.println("Enter account's ID, you want to delete: ");
            Long accountId = Long.valueOf(reader.readLine());
            Accounts account = accountsService.findById(accountId);
            accountsService.delete(account);
            System.out.println(color.RED + "Account was deleted!" + color.YELLOW);
        } catch (SecurityException e) {
            System.out.println("ID is incorrect, attempt another.");
        } catch (Exception e) {
            System.out.println("Unknown error.");
        }
    }

    private static void findByIdAccount(BufferedReader reader) throws IOException {
        System.out.println("Enter account's ID, you want to find: ");
        Long accountId = Long.valueOf(reader.readLine());
        Accounts account = accountsService.findById(accountId);
        if (account != null) {
            System.out.println(color.CYAN + "Account: " + color.WHITE + account + color.YELLOW);
        } else {
            System.out.println("ID is incorrect, check entered data.");
        }
    }

    private static void seeAllAccounts() {
        Collection<Accounts> accounts = accountsService.findAll();
        System.out.println(color.CYAN + "Accounts:" + color.YELLOW);
        for (Accounts account : accounts) {
            if (account != null) {
                System.out.println(color.WHITE + account + color.YELLOW);
            }
        }
    }
}
