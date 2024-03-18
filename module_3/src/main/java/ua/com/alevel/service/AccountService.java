package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.Account;

import java.util.Collection;
import java.util.Date;

public interface AccountService {

    void create(Account account);
    void update(Long id, Account account);
    void delete(Long id);
    Account findById(Long id);
    Collection<Account> findAll();

    void exportToCsv(Account account, Date fromDate, Date toDate);

    Collection<Account> findAccountsByClientId(Long id);

    Account findAccountByAccountNumber(int accountNumber);
}
