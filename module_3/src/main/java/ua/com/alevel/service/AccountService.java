package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.bank.Account;

import java.util.Collection;
import java.util.Date;

public interface AccountService {   // тут уже работаем с конкретными объектами

    void exportToCsv(Account account, Date fromDate, Date toDate);

    Collection<Account> findAccountsByClientId(Long id);

    Account findAccountByAccountNumber(int accountNumber);

    void create(Account account);

    void update(Long id, Account account);

    Account findById(Long id);

    Collection<Account> findAll();

    void delete(Long id);
}
