package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.collections4.CollectionUtils;

import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourImage;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TourPDPDto {

    private Long id;
    private String country;

    private String rout;
    private String durationFirst;
    private String durationSecond;
    private String nutrition;
    private String priceFirst;
    private String priceSecond;

    private Set<String> images;

    public TourPDPDto(Tour tour, TourVariant tourVariant) {
        this.id = tour.getId();
        this.country = tour.getCountry();

        this.rout = tourVariant.getRout();
        this.durationFirst = tourVariant.getDurationFist();
        this.durationSecond = tourVariant.getDurationSecond();
        this.nutrition = tourVariant.getNutrition();
        this.priceFirst = tourVariant.getPriceFist();
        this.priceSecond = tourVariant.getPriceSecond();

        Set<TourImage> tourImages = tour.getTourImages();
        if (CollectionUtils.isNotEmpty(tourImages)) {
            this.images = tourImages.stream().map(TourImage::getImageUrl).collect(Collectors.toSet());
        }
//        if (CollectionUtils.isNotEmpty(tourVariants)) {
//            this.rout = tourVariants.stream().map(TourVariant::getRout).toList();
//            this.cpuList = productVariants.stream().map(ProductVariant::getCpu).distinct().toList();
//            this.ramList = productVariants.stream().map(ProductVariant::getRam).distinct().toList();
//            this.ssdList = productVariants.stream().map(ProductVariant::getSsd).distinct().toList();
//            this.colorList = productVariants.stream().map(ProductVariant::getColor).distinct().toList();
//            List<ProductDisplay> productDisplayList = productVariants.stream().map(ProductVariant::getProductDisplay).toList();
//            if (CollectionUtils.isNotEmpty(productDisplayList)) {
//                this.displayResolutionList = productDisplayList.stream().map(ProductDisplay::getDisplayResolution).distinct().toList();
//                this.displayTypeList = productDisplayList.stream().map(ProductDisplay::getDisplayType).distinct().toList();
//                this.displaySizeList = productDisplayList.stream().map(ProductDisplay::getDisplaySize).distinct().toList();
//            }
    }
}
