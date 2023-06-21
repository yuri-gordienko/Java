package ua.com.alevel.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "electives")
public class Electives extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable( // описываем алгоритм генерации 3й таблицы, данная таблица главная, к ней и присоединяем второстепенную
            name = "relation_table",    // имя 3й таблицы
            joinColumns = @JoinColumn(name = "el_id"), // это главная колонка, к ней присоединяем второстепенную
            inverseJoinColumns = @JoinColumn(name = "pup_id")   // второстепенная колонка, ее и присоединяем
    )

    private Set<Pupils> pupil = new HashSet<>(); // HashSet значит что при старте объект будет дефолтный

    public String getName() {

        return name;
    }

    public boolean setName(String name) {
        boolean correctName = false;
        if (name == "") {
            System.out.println("Ви не ввели назву курсу");
            return false;
        }
        if (name.matches(".*\\d.*") || name.equals("")) {
            System.out.println("Така назва не коректна");
            System.out.println("Будь ласка, введіть коректну назву, без символів та цифр");
            System.out.println();
        } else {
            this.name = name;
            correctName = true;
        }
        return correctName;
    }

    public Set<Pupils> getPupil() {

        return pupil;
    }

    public void setPupil(Set<Pupils> pupil) {

        this.pupil = pupil;
    }

    public String toString() {

        return super.toString() + ", " + " Назва: " + name;
    }
}
