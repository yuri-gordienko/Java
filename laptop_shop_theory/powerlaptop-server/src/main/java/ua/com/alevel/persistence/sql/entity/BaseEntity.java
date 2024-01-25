package ua.com.alevel.persistence.sql.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass // указываем что это суперклас для всех энтитей, для того чтоб id был всем виден, т.е  данное поле
// будет входить в филды других таблиц (классов наследников), но сам при этом таблицей не является
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY - генерирует по инкременту, т.к i + 1
    private Long id;
}