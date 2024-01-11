package yugo.dao;

import yugo.entity.BaseEntity;

import java.sql.SQLException;
import java.util.Collection;

// інтерфейс, що реалізує абстрактні методи, безпосередньо контактує з БД. Таким чином в БД не звуртаються сотні класів,
// кожен зі своєю імплементацією, а працюють через один універсальний інтерфейс.
// Один абстрактний метод може виконувати CRUD операції для різних сущностей
// дуже удобно, щоб не писати релізацію для багатьох класів
// І ТІЛЬКИ BaseDao ІДЕ ДО ЗВʼЯЗУЮЧЕГО ЗВЕНА З БАЗОЮ JdbcConnector І ОТРИМУЄ СЕСІЮ ДЛЯ КОЖНОЇ ОПЕРАЦІЇ
// щоб нащадки BaseDao мали можливість виконувати усі доступні методи, робимо його нащадком BaseEntity
public interface BaseDao <E extends BaseEntity> {

    void create (E e);
    void update (E e);
    void delete (Long id);
    E findById(Long id);
    Collection<E> findAll() throws SQLException;
}
