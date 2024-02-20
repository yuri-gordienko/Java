package ua.com.alevel.persistence.sql.entity.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import ua.com.alevel.persistence.sql.type.RoleType;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin() {
        super();
        setRoleType(RoleType.ADMIN);
    }
}
