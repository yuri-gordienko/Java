package ua.com.alevel.service.impl;

import au.com.bytecode.opencsv.CSVWriter;
import ua.com.alevel.persistence.entity.product.Accounts;
import ua.com.alevel.persistence.entity.product.Clients;
import ua.com.alevel.persistence.repository.AccountsDao;
import ua.com.alevel.persistence.repository.impl.AccountsDaoImpl;
import ua.com.alevel.service.AccountsService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static ua.com.alevel.persistence.enums.AccountStatement.Enum.HISTORY_FILE;

public class AccountServiceImpl implements AccountsService {

    private final AccountsDao accountsDao = new AccountsDaoImpl();

    @Override
    public void create(Accounts accounts) {

        accountsDao.create(accounts);
    }

    @Override
    public void update(Accounts accounts, Long id) {
        Optional<Accounts> optionalAccounts = accountsDao.findById(id);
        if (optionalAccounts.isPresent()) {
            accounts.setId(id);
            accountsDao.update(accounts);
        } else {
            System.out.println("Check entered data.");
        }
    }

    @Override
    public void delete(Accounts accounts) {

        accountsDao.delete(accounts);
    }

    @Override
    public Accounts findById(Long id) {
        Optional<Accounts> optionalAccounts = accountsDao.findById(id);
        if (optionalAccounts.isPresent()) {
            return accountsDao.findById(id).get();
        } else {
            throw new SecurityException("ID is incorrect, check entered data!");
        }
    }

    @Override
    public Collection<Accounts> findAll() {
        return accountsDao.findAll();
    }

    private List<Clients> clients = new ArrayList<>();
    @Override
    public void exportToCsv() {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(HISTORY_FILE))) {
            List<String[]> list = new ArrayList<>();
            String[] client1 = {"id, age, e-mail, Firstname", "Lastname",};
            csvWriter.writeNext(client1);
            for (Clients client : clients) {
                String [] st = new String[]{
                        String.valueOf(client.getId()),
                        String.valueOf(client.getAge()),
                        client.getEmail(),
                        client.getFirstName(),
                        client.getFirstName()
                };
                list.add(st);
            }
        csvWriter.writeAll(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        List<String[]> writeOutList = new ArrayList<>();
//        writeOutList.add(new String[]{
//                "Age", "Email, First name", "Last name"
//        });
//        List<Transaction> transactions = findAllTransactionsByAccount(id)
//                .stream()
//                .filter((x) -> x.getDate().isAfter(minDate) && x.getDate().isBefore(maxDate))
//                .collect(Collectors.toList());
//        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("accountId_" + id + "_transactions.csv"))) {
//            for (Transaction transaction : transactions) {
//                String[] transactionsString = new String[7];
//                transactionsString[0] = transaction.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                transactionsString[1] = String.valueOf(MoneyConvertorUtil.moneyConversionInDouble(findById(id).getBalance()));
//                transactionsString[2] = transaction.getSender().getUser().getName();
//                transactionsString[3] = transaction.getSender().getWallet();
//                transactionsString[4] = String.valueOf(MoneyConvertorUtil.moneyConversionInDouble(transaction.getAmount()));
//                transactionsString[5] = transaction.getReceiver().getUser().getName();
//                transactionsString[6] = transaction.getReceiver().getWallet();
//                writeOutList.add(transactionsString);
//            }
//            csvWriter.writeAll(writeOutList);
//        } catch (IOException e) {
//        }
    }
}