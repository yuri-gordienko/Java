package ua.com.alevel.persistence.repository.bank;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.bank.Account;
import ua.com.alevel.persistence.entity.bank.DebitOperation;

import java.util.Date;
import java.util.List;

@Repository("uniqueDebitRepository")
public interface DebitOperationRepository extends OperationRepository {

    List<DebitOperation> findByRecipientAccountAndOperationDateBetween(Account account, Date fromDate, Date toDate);
}
