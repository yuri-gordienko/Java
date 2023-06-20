package ua.com.alevel.persistence.sql.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.listener.FullNameGenerationListener;
import ua.com.alevel.persistence.sql.type.RoleType;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity // эта онатация говорит о том что есть такая таблица
@Table(name = "users")  // здесь будут лежать все Пользователи - юзеры и админы, iscriminatorValue распределяет их по ролям
@EntityListeners({  // чтоб заработал Listener,
        FullNameGenerationListener.class    // FullNameGenerationListener можно создать сколько угодно
})
public class User extends BaseEntity implements UserDetails { // имплементируем, чтоб из Юзера вернулся готовый Юзер детеилз

    @Column(nullable = false, unique = true)    // уникальный для возможности логиниться через внешнюю систему
    // например фейсбук не вернет имейл, он вернет на бэкенд хештокинг по которому мы будем идти в на сервак, направлять наружу,
    // принимать запрос, перенаправлять в фейсбук, фейс говорит да это реальный чел, можно регистрировать
    private String username;    // поле, которое мы будем отправлять в логине

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private String password;

    private Boolean enabled;

    @Transient  // не сохраняется в базу
    private String fullName;

    @Enumerated(EnumType.STRING)    // тип юзера (обычный юзер или админ)
    @Column(name = "role_type", nullable = false)
    private RoleType roleType;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    public User() {
        super();
        this.enabled = true;    // отвечает заблочен юзер или нет, если логин проходит а false то бэкап
        this.accountNonExpired = true;  // когда временно живет юзер то проверяет сроки
        this.credentialsNonExpired = true; // если общие сроки в порядке, то какие-то услуги все же могут не работать временно
        this.accountNonLocked = true; // не понятно зачем если есть ключевой параметр enabled = true
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // вот и создали Грантедауторити (уровни прав доступа юзеру)
        return Set.of(new SimpleGrantedAuthority(roleType.name())); // из енамчика берем имя для нашего примера, чтоб работал
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
