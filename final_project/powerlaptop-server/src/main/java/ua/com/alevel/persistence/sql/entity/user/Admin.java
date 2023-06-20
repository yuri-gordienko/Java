package ua.com.alevel.persistence.sql.entity.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import ua.com.alevel.persistence.sql.type.RoleType;


//jakarta.persistence. это jpa, это Бызы данных, это стандарт
//DiscriminatorValue - дискриминация, негры белые, юзеры админы

@Entity
@DiscriminatorValue("ADMIN")    // и админы и персоналс будут жить как 2 таблицы в таблице наследнике Юзерс
public class Admin extends User {   // наследник Юзера

    public Admin() {    // конструктор
        super();
        setRoleType(RoleType.ADMIN);   // назначаем роль
    }
}
