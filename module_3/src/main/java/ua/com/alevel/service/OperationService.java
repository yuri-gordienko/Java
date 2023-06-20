package ua.com.alevel.service;

import java.math.BigDecimal;

public interface OperationService {

    void transferMoney(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
