package ua.com.alevel.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@MappedSuperclass // чтоб не мапился на таблицу
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // вариант генерации id по инкременту
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    public BaseEntity() {

        this.updated = new Date();
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Date getUpdated() {

        return updated;
    }

    public void setUpdated(Date updated) {

        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public String toString() {

        return "> ID: " + id;
    }
}


