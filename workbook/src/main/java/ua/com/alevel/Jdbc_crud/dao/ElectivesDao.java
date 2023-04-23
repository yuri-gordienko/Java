package ua.com.alevel.Jdbc_crud.dao;

import ua.com.alevel.dto.ElectivesDto;
import ua.com.alevel.entity.Electives;
import ua.com.alevel.entity.Pupils;

import java.util.Collection;

// по дефолту этот универсальный метод реализует CRUD
public interface ElectivesDao extends BaseDao<Electives> {

    // помимо стандартных наборов (public API) делаем дополнительные фитчи
    void attachPupilsToElectives(Long electivesId, Long pupilsId);

    void detachPupilsToElectives(Long electivesId, Long pupilsId);

    Collection<ElectivesDto> findPupilsByElectives();

    Collection<ElectivesDto> findElectivesStatistics(); // возвращает множество листов (коллекцию)
    // String sortBy - по какой колонке сортировать, DBOrderUtil - прилетает ENUM, orderBy - сортируем по enum
}
