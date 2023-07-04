package ua.com.alevel.facade.process;

import ua.com.alevel.data.dto.tour.TourProcessDto;

public interface TourProcessFacade {

    void attach(Long id, TourProcessDto dto);
    void detach(Long id, TourProcessDto dto);
}
