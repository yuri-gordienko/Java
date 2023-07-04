package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;

//import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class TourVariantDto extends BaseDto {

    private String rout;
//    private String duration;
//    private String nutrition;
//    private String priceFirst;
//    private String priceSecond;

    public TourVariantDto(TourVariant tourVariant) {
        setId(tourVariant.getId());
        this.rout = tourVariant.getRout();
//        this.duration = tourVariant.getDuration();
//        this.nutrition = tourVariant.getNutrition();
//        this.priceFirst = tourVariant.getPriceFist();
//        this.priceSecond = tourVariant.getPriceSecond();
    }
}
