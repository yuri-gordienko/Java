package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourImage;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;

//import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TourPDPDto {

    private Long id;
    private String country;
    private String description;

    private Set<String> images;

    private String rout;
//    private String duration;
//    private String nutrition;
    private String priceFirst = "100.00";
    private String priceSecond = "170.00";

    public TourPDPDto(Tour tour, TourVariant tourVariant) {
        this.id = tour.getId();
        this.country = tour.getCountry();
        this.description = tour.getDescription();

        this.rout = tourVariant.getRout();
//        this.duration = tourVariants.getDuration();
//        this.nutrition = tourVariants.getNutrition();

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
