package ua.com.alevel.persistence.sql.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


//public enum RoleType { // Авторизация, т.е. грантед аусорити (права доступа)
//    ROLE_ADMIN, // создаем ручками мы
//    ROLE_PERSONAL   // регистрируется сам через сайт

import static ua.com.alevel.persistence.sql.type.Permission.*;

    @RequiredArgsConstructor
    public enum RoleType {  // ауторитис для ролей
        PERSONAL(Collections.emptySet()),
        ADMIN(
                Set.of(
                        ADMIN_READ,
                        ADMIN_UPDATE,
                        ADMIN_DELETE,
                        ADMIN_CREATE,
                        MANAGER_READ,
                        MANAGER_UPDATE,
                        MANAGER_DELETE,
                        MANAGER_CREATE
                )
        ),
        MANAGER(
                Set.of(
                        MANAGER_READ,
                        MANAGER_UPDATE,
                        MANAGER_DELETE,
                        MANAGER_CREATE
                )
        )

        ;

        @Getter
        private final Set<Permission> permissions;

        public List<SimpleGrantedAuthority> getAuthorities() {
            var authorities = getPermissions()
                    .stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                    .collect(Collectors.toList());
            authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
            return authorities;
        }
    }
