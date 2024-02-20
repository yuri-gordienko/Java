package ua.com.alevel.persistence.sql.entity.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import ua.com.alevel.persistence.sql.type.RoleType;

@Entity
@DiscriminatorValue("PERSONAL")
public class Personal extends User {

    public Personal() {
        super();
        setRoleType(RoleType.PERSONAL);
    }
}
