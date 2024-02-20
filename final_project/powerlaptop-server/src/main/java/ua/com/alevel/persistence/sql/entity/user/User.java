package ua.com.alevel.persistence.sql.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.entity.token.Token;
import ua.com.alevel.persistence.sql.listener.FullNameGenerationListener;
import ua.com.alevel.persistence.sql.type.RoleType;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
@EntityListeners({
        FullNameGenerationListener.class
})
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private String password;

    private Boolean enabled;

    @Transient
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", nullable = false)
    private RoleType roleType;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    public User() {
        super();
        this.enabled = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleType.getAuthorities();
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
