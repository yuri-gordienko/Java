package ua.com.alevel.dao;

import ua.com.alevel.dto.ElectivesDto;
import ua.com.alevel.entity.Electives;

import java.util.Collection;

public interface ElectivesDao extends BaseDao<Electives> {

    void attachPupilsToElectives(Long electivesId, Long pupilsId);

    void detachPupilsToElectives(Long electivesId, Long pupilsId);

    Collection<ElectivesDto> findElectivesStatistics();
}
