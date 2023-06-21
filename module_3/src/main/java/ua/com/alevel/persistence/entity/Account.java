package ua.com.alevel.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity // ставим всегда над классом, который будет мапиться на таблицу, BaseEntity это не таблица, она отдает свой филд наследникам
@Table(name = "accounts")   // а вот без этой аннотации обойтись можно, по дефолту будет называть именем джава класса
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

    // хороший вариант аннотации, просто указываем что к чему присоединить и название филда
    // в таком случае много Акаунтов (сам класс говорит за себя) к одному клиенту (поэтому не нужно указывать коллекцию)
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // в таком варианте аннотации кужно добавлять филд солекшина (лучше писать Set)
    // этот вариант плохой, т.к. нужно писать еще 3ю реалиционную таблицу, чтобзасунуть туда эту коллекцию операций
    // т.е. один аккаунт относиться к коллекции операций
    // mappedBy указываем на какой филд в табл "accounts", будем ссылаться из List<DebitOperation>
    @OneToMany(mappedBy = "recipientAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DebitOperation> debitOperations;

    @OneToMany(mappedBy = "senderAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CreditOperation> creditOperations;

    // при @ManyToMany соллекции создаем в обоих связующих классах, при этом нужно указать какая таблица главная
//    @ManyToMany (mappedBy = "employees") т.е. на какой филд в табл employees ссылаться нашему <Departmetn>
//    @JoinTable( // описываем алгоритм генерации 3й таблицы, данная таблица главная, к ней и присоединяем второстепенную
//            name = "relation_table",    // имя 3й таблицы
//            joinColumns = @JoinColumn(name = "el_id"), // это главная колонка, к ней присоединяем второстепенную
//            inverseJoinColumns = @JoinColumn(name = "pup_id")   // второстепенная колонка, ее и присоединяем
//    )
//    private Set<Departmetn> departments;
}
