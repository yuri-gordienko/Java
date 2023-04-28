package ua.com.alevel.dao;

import ua.com.alevel.dto.ElectivesDto;
import ua.com.alevel.entity.Electives;
import ua.com.alevel.entity.Pupils;

import java.util.Collection;

public interface ElectivesDao extends BaseDao<Electives> {

    boolean existByName(String name);

    void attachPupilsToElectives(Electives electives, Pupils pupils);

    void detachPupilsToElectives(Electives electives, Pupils pupils);

    Collection<ElectivesDto> findElectivesStatistics();
}
