package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.collections4.CollectionUtils;

import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourImage;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TourPDPDto {

    private Long id;
    private String country;

    private List<String> routList;
    private List<String> durationFirstList;
    private List<String> durationSecondList;
    private List<String> nutritionList;
    private List<String> priceFirstList;
    private List<String> priceSecondList;

    private Set<String> images;

    public TourPDPDto(Tour tour, Collection<TourVariant> tourVariants) {
        this.id = tour.getId();
        this.country = tour.getCountry();

        Set<TourImage> tourImages = tour.getTourImages();
        if (CollectionUtils.isNotEmpty(tourImages)) {
            this.images = tourImages.stream().map(TourImage::getImageUrl).collect(Collectors.toSet());
        }
        if (CollectionUtils.isNotEmpty(tourVariants)) {
            this.routList = tourVariants.stream().map(TourVariant::getRout).distinct().toList();
            this.durationFirstList = tourVariants.stream().map(TourVariant::getDurationFist).distinct().toList();
            this.durationSecondList = tourVariants.stream().map(TourVariant::getDurationSecond).distinct().toList();
            this.nutritionList = tourVariants.stream().map(TourVariant::getNutrition).distinct().toList();
            this.priceFirstList = tourVariants.stream().map(TourVariant::getPriceFist).distinct().toList();
            this.priceSecondList = tourVariants.stream().map(TourVariant::getPriceSecond).distinct().toList();
        }
    }
}
