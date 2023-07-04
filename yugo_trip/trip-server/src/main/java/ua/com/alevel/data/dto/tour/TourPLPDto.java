package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourImage;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TourPLPDto {

    private Long id;
    private String country;
//    private String summary;
    private String image;
    private String price = "100.00";

    public TourPLPDto(Tour tour) {
        this.id = tour.getId();
        this.country = tour.getCountry();
//        this.summary = tour.getSummary();

        Set<TourImage> tourImages = tour.getTourImages();
        if (CollectionUtils.isNotEmpty(tourImages)) {
            TourImage tourImage = tourImages
                    .stream()
                    .filter(TourImage::getMainImage)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Main image not found"));
            this.image = tourImage.getImageUrl();
        }
    }
}
