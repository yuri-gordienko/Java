package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.tour.TourImage;

@Getter
@Setter
@NoArgsConstructor
public class TourImageDto extends BaseDto {

    private String imageUrl;
    private Boolean mainImage;

    public TourImageDto(TourImage tourImage) {
        setId(tourImage.getId());
        this.imageUrl = tourImage.getImageUrl();
        this.mainImage = tourImage.getMainImage();
    }
}
