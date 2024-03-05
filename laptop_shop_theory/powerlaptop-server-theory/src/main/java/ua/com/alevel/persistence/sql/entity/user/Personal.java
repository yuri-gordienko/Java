package ua.com.alevel.persistence.sql.entity.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import ua.com.alevel.persistence.sql.type.RoleType;

//jakarta.persistence. это jpa, это Бызы данных, это стандарт
//DiscriminatorValue - дискриминация, негры белые, юзеры админы

@Entity
@DiscriminatorValue("PERSONAL") // и админы и персоналс будут жить как 2 таблицы в таблице наследнике Юзерс
public class Personal extends User {    // Personal наследник Юзера

    public Personal() { // конструктор
        super();
        setRoleType(RoleType.PERSONAL); // назначаем роль
    }
}
