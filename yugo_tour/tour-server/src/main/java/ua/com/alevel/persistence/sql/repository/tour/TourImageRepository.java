package ua.com.alevel.persistence.sql.repository.tour;

import org.springframework.stereotype.Repository;

import ua.com.alevel.persistence.sql.entity.tour.TourImage;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.Set;

@Repository
public interface TourImageRepository extends BaseEntityRepository<TourImage> {
    Set<TourImage> findAllByIdIn(Set<Long> ids);
}
