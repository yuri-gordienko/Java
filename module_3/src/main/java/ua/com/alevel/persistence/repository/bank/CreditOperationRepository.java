package ua.com.alevel.persistence.repository.bank;

import org.springframework.stereotype.Repository;

import ua.com.alevel.persistence.entity.bank.Account;
import ua.com.alevel.persistence.entity.bank.CreditOperation;

import java.util.Date;
import java.util.List;

@Repository("uniqueCreditRepository")
public interface CreditOperationRepository extends OperationRepository {

    List<CreditOperation> findBySenderAccountAndOperationDateBetween(Account account, Date fromDate, Date toDate);
}
