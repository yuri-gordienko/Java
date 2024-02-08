package ua.com.alevel.facade.plp;

import ua.com.alevel.data.dto.tour.TourPLPDto;

import java.util.Collection;

public interface TourPLPFacade {

    Collection<TourPLPDto> findAll();
}
