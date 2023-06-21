package ua.com.alevel.persistence.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass   // содержит филды другого класса, но сам при этом не является таблицей
// нет аннотации @Entity т.к. не создается (не мапиться) таблица
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автогенерация id, с использованием стратегии IDENTITY (путем инкремента)
    private Long id;
}
