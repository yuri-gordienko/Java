package ua.com.alevel.persistence.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ua.com.alevel.persistence.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Operations extends BaseEntity {

    @Column(name = "operation_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date operationDate;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "amount")
    private BigDecimal amount;
    @ManyToOne
    private Accounts senderAccounts;
    @ManyToOne
    private Accounts receiverAccounts;

    public Operations() {
    }
}
