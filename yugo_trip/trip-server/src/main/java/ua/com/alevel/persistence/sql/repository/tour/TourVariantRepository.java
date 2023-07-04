package ua.com.alevel.persistence.sql.repository.tour;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface TourVariantRepository extends BaseEntityRepository<TourVariant> {
//    Collection<TourVariant> findByTour(Tour tour);
//    TourVariant findByTour(Tour tour);

    Optional<TourVariant> findByTour(Tour tour);

}
