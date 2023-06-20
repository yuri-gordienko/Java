package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Account;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface AccountRepository extends BaseRepository<Account> {

    Collection<Account> findAccountsByClientId(Long id);

    Optional<Account> findAccountByAccountNumber(int accountNumber);
}
