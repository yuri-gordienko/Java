package ua.com.alevel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)    //код продукта по которому получаем цену и кол-во у поставщика
    private String code;

    @Column(nullable = false)   // добавляем в нашу базу доп.колонку (количество на остатках)
    private Integer quantity;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
}