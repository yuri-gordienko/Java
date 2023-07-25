package ua.com.alevel.persistence.sql.repository.tour;

import org.springframework.stereotype.Repository;

import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

@Repository
public interface TourRepository extends BaseEntityRepository<Tour> { }
