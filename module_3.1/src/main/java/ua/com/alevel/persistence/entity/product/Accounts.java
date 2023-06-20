package ua.com.alevel.persistence.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name = "accounts")
public class Accounts extends BaseEntity {

        private String bank;
        private long balance;

        @ManyToOne()
        @JoinColumn(name = "clients_id", referencedColumnName = "id")
        private Clients clients;

        @OneToMany(mappedBy = "receiver") // mappedBy - на какой филд ссылаться
        private List<Transactions> receiver;

        @OneToMany(mappedBy = "sender")
        private List<Transactions> sender;

        public Accounts() {
            super();
            this.receiver = new ArrayList<>();
            this.sender = new ArrayList<>();
        }

        public List<Transactions> getTransactions() {
            List<Transactions> transactionsList = new ArrayList<>();
            transactionsList.addAll(sender);
            transactionsList.addAll(receiver);
            return transactionsList;
        }
}