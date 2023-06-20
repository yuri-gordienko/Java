package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.entity.CreditOperation;

import java.util.Date;
import java.util.List;

@Repository
public interface CreditOperationRepository extends OperationRepository {

    List<CreditOperation> findBySenderAccountAndOperationDateBetween(Account account, Date fromDate, Date toDate);
}
