package ua.com.alevel.service.impl;

import com.opencsv.CSVWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.entity.Operation;
import ua.com.alevel.persistence.repository.AccountRepository;
import ua.com.alevel.persistence.repository.CreditOperationRepository;
import ua.com.alevel.persistence.repository.DebitOperationRepository;
import ua.com.alevel.service.AccountService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static ua.com.alevel.utils.enums.AccountStatement.Enum.HISTORY_FILE;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CreditOperationRepository creditOperationRepository;
    private final DebitOperationRepository debitOperationRepository;

    @Override
    public Account findById(Long id) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        return foundAccount.orElse(null);
    }

    @Override
    public Collection<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Collection<Account> findAccountsByClientId(Long id) {
        return accountRepository.findAccountsByClientId(id);
    }

    @Override
    public Account findAccountByAccountNumber(int accountNumber) {
        Optional<Account> foundAccount = accountRepository.findAccountByAccountNumber(accountNumber);
        return foundAccount.orElse(null);
    }

    @Transactional
    @Override
    public void create(Account account) {
        int min = 100_000;
        int max = 999_999;
        int random = (int) (Math.random() * (max - min + 1) + min);
        account.setAccountNumber(random);
        accountRepository.save(account);
    }

    @Transactional
    @Override
    public void update(Long id, Account updatedAccount) {
        updatedAccount.setId(id);
        accountRepository.save(updatedAccount);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void exportToCsv(Account account, Date fromDate, Date toDate) {
        try {
            FileWriter writer = new FileWriter(HISTORY_FILE);
            CSVWriter csvWriter = new CSVWriter(writer);
            String[] header = {"Категорія", "Сума", "Дата", "Отримувач", "№ рахунку", "Відправник", "№ рахунку",};
            csvWriter.writeNext(header);
            List<Operation> operations = new ArrayList<>();
            operations.addAll(debitOperationRepository.findByRecipientAccountAndOperationDateBetween(account, fromDate, toDate));
            operations.addAll(creditOperationRepository.findBySenderAccountAndOperationDateBetween(account, fromDate, toDate));
            for (Operation operation : operations) {
                String[] data = {operation.getCategory().toString(), operation.getAmount().toString(), operation.getOperationDate().toString(), operation.getRecipientAccount().getAccountName(), String.valueOf(operation.getRecipientAccount().getAccountNumber()), operation.getSenderAccount().getAccountName(), String.valueOf(operation.getSenderAccount().getAccountNumber())};
                csvWriter.writeNext(data);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
