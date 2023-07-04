package ua.com.alevel.facade.pdp;

import ua.com.alevel.data.dto.tour.TourPDPDto;

public interface TourPDPFacade {

    TourPDPDto findById(Long id);
//    Long findProductIdByVariants(ProductSearchDto dto);
}
