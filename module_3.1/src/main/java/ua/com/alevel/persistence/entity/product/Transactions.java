package ua.com.alevel.persistence.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.persistence.entity.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "transactions")
public class Transactions extends Operations {

    public Transactions() { super(); }

    @ManyToOne()
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Accounts sender;

    @ManyToOne()
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Accounts receiver;
}