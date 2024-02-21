package ua.com.alevel.persistence.entity.bank;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "DebitAccount")
@Table(name = "debit_transactions")
public class DebitOperation extends Operation { }
