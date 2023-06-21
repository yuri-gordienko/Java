package ua.com.alevel.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository; // самый популярный
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ua.com.alevel.persistence.entity.BaseEntity;

@NoRepositoryBean
// эта аанотация говорит Спрингу, что делать под этот класс имплементацию не нужно, т.к. он не является Энтити
// т.е. BaseEntity не мапится на таблицу, соответственно имплементировать ее не нужно
// имплементируем только те классы, которые @Entity, являются таблицами и несут бизнес логику
// а вот уже абстрактные методы, которые внутри его должны быть реализованы в наследниках

public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> { } // более мощьный, чем CrudRepository
//public interface BaseRepository<E extends BaseEntity> extends CrudRepository<E, Long> { }

// если наследуемся от CrudRepository, то CRUD методы уже под капотом, не надо прописывать каждый метод как в Хайбернейт
// CrudRepository<E, ID> наследуется от Repository<E, ID> сканирует проект и ищет все классы кот. наследники Repository
// а его наследники уже не будут требовать имплементации, т.к. за них это сделает Спринг, т.е.
// стандартные методы он делает автоматом, а дополнительные прописываем на Спринг диалекте (под капотом sql запросы)
// все методы оборачивает в транзакции и выполняет

