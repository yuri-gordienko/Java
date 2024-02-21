package ua.com.alevel.persistence.entity.bank;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "CreditAccount")
@Table(name = "credit_transactions")
public class CreditOperation extends Operation { }
