package ua.com.alevel.persistence.entity.bank;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.List;

@Getter
@Setter
@Entity(name = "ClientAccount")
@Table(name = "clients")
public class Client extends BaseEntity {

    @Column(name = "full_name")
    @NotEmpty(message = "Поле має бути заповненим!")
    @Size(min = 1, max = 255, message = "Ім'я може містити від 1 до 255 літер.")
    private String fullName;

    @Column(name = "email")
    @Email(message = "e-mail не коректний, будь ласка перевірте введені дані.")
    @NotEmpty(message = "Поле має бути заповненим!")
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> accounts;
}
