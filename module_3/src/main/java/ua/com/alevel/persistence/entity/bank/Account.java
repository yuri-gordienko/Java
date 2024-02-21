package ua.com.alevel.persistence.entity.bank;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity(name = "BankAccount")
@Table(name = "accounts")
public class Account extends BaseEntity {

    @Column(name = "account_name")
    @NotEmpty(message = "Поле має бути заповненим!")
    @Size(min = 1, max = 255, message = "Ім'я може містити від 1 до 255 літер.")
    private String accountName;

    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "balance")
    @NotNull(message = "Поле має бути заповненим!")
    @Min(value = 0, message = "Баланс не має бути меньшим за 0!")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "recipientAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DebitOperation> debitOperations;

    @OneToMany(mappedBy = "senderAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CreditOperation> creditOperations;
}
